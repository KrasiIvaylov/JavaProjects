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
import java.util.List;
import java.util.stream.Collectors;

public class EntityManagerImpl implements EntityManager {
    private final Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    @SuppressWarnings("unchecked")
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
        T entity = (T) type.getConstructors()[0].newInstance();

        ResultSet result = stmt.executeQuery();
        if (!result.next()) {
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

    @Override
    public <T> boolean persist(T entity) throws IllegalAccessException, SQLException {
        Field idField = getIdFieldFromEntity(entity);
        idField.setAccessible(true);
        int id = (int) idField.get(entity);

        if (id == 0) {
            return doInsert(entity);
        }
        // doUpdate(id, entity );

        System.out.println();
        return false;
    }

    private <T> boolean doInsert(T entity) throws SQLException {
        String tableName = getTableNameByEntity(entity);
        String fieldsNames = getFieldsNamesBy(entity.getClass());
        String fieldsValues = getFieldsValuesAsStr(entity);

        System.out.println();

        String query = String.format("INSERT INTO %s (%s) VALUES (%s) ",
                tableName, fieldsNames, fieldsValues);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        return preparedStatement.executeUpdate() > 0;
    }

    private <T> String getFieldsValuesAsStr(T entity) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    String name = field.getAnnotation(Column.class).name();
                    String type = field.getAnnotation(Column.class).columnDefinition();
                    Object fieldValue = null;
                    try {
                        fieldValue = field.get(entity);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (type.equals("DATE") || type.equals("VARCHAR")){
                        sb.append(" '").append(fieldValue).append("' ")
                                .append(" ,");
                    }else{
                        sb.append(" '").append(fieldValue).append("' ")
                                .append(" ,");
                    }

                });
//        return Arrays.stream(entity
//                .getClass()
//                .getDeclaredFields())
//                .filter(field -> field.isAnnotationPresent(Column.class))
//                .map(field -> {
//                    try {
//                        return getValueToString(field, entity);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                })
//                .collect(Collectors.joining(" , "));
        return sb.toString().substring(0, sb.length() - 2);
    }

    private String getFieldsNamesBy(Class<?> aClass) {
        return Arrays.stream(aClass
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> {
                    return field.getAnnotation(Column.class)
                            .name();
                })
                .collect(Collectors.joining(" ,"));
    }

    private <T> String getTableNameByEntity(T entity) {
        return entity
                .getClass()
                .getAnnotation(Entity.class)
                .tableName();
    }

    private <T> Field getIdFieldFromEntity(T entity) {
        return Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity doesn't have id"));
    }

    private <T> String getValueToString(Field field, T entity) throws IllegalAccessException {
        String type = field.getAnnotation(Column.class).columnDefinition();

        if (type.equals("DATE") || type.equals("VARCHAR")) {
            try {
                return String.format(" '%s' ", field.get(entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return String.format(" %s ", field.get(entity));
    }
}
