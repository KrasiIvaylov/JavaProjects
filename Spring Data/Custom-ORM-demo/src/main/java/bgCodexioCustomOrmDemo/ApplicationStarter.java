package bgCodexioCustomOrmDemo;

import ormFramework.core.EntityManagerFactory;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class ApplicationStarter {
    public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException {
        EntityManagerFactory.create(
                "mysql",
                "localhost",
                3306,
                "root",
                "12345",
                "test_orm",
                ApplicationStarter.class
        );
    }
}
