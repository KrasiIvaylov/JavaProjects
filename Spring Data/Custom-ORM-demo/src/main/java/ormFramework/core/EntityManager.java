package ormFramework.core;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager {

   <T> T findById(int id, Class<T> type) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
