package ormFramework.core;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;

public class EntityManagerImpl implements EntityManager {
    private final Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> T findById(int id, Class<T> type) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String tableName = type.getAnnotation(Entity.class).tableName();
       String idColumnName = Arrays.stream(type.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow()
                .getName();

        PreparedStatement stmt =
                this.connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + " ?");
        stmt.setInt(1, id);
        T entity = (T)type.getConstructors()[0].newInstance();

        ResultSet result = stmt.executeQuery();
        if (!result.next()){
            return null;
        }
        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnInfo = field.getAnnotation(Column.class);
                String setterName = "set" + ((field.getName().charAt(0) + "").toUpperCase()) + field.getName().substring(1);
                if (field.getType().equals(String.class)) {
                    String s = result.getString(columnInfo.name());
                    type.getMethod(setterName, String.class).invoke(entity, s);
                } else {
                    int s = result.getInt(columnInfo.name());
                    type.getMethod(setterName, field.getType()).invoke(entity, s);
                }
            } else if (field.isAnnotationPresent(Id.class)) {
                String setterName = "set" + ((field.getName().charAt(0) + "").toUpperCase()) + field.getName().substring(1);
                type.getMethod(setterName, String.class).invoke(entity, id);
            }
        }
        return entity;
    }
}
