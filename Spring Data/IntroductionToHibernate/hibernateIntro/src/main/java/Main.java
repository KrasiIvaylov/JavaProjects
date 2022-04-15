import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        Session session = new Configuration()
                .configure()
                .addProperties(properties)
                .buildSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        transaction.commit();
    }
}
