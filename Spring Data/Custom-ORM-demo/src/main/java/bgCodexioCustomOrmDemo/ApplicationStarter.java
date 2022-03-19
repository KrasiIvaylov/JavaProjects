package bgCodexioCustomOrmDemo;

import bgCodexioCustomOrmDemo.entity.Address;
import bgCodexioCustomOrmDemo.entity.Employee;
import bgCodexioCustomOrmDemo.entity.User;
import ormFramework.core.EntityManager;
import ormFramework.core.EntityManagerFactory;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class ApplicationStarter {
    public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException,
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       EntityManager entityManager = EntityManagerFactory.create(
                "mysql",
                "localhost",
                3306,
                "root",
                "12345",
                "test_orm",
                ApplicationStarter.class
        );
        User user = new User("Pesho", 27);
        assert entityManager != null;
        entityManager.persist(user);

//       Employee byId = entityManager.findById(25, Employee.class);
//       Address softUniAddress = entityManager.findById(1, Address.class);
//       Address codexioAddress = entityManager.findById(2, Address.class);
    }
}
