package ormFramework.core;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager {

   <T> T findById(int id, Class<T> type) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

   <T> boolean persist(T entity) throws IllegalAccessException, SQLException;
//   <T> boolean delete(T entity);
//   <T> boolean alterTable(T entity);
}
