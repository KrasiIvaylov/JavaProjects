import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class Main {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;


    public static void main(String[] args) throws SQLException, IOException {
        connection = getConnection();

        System.out.println("Enter Exercise:");
        int exercise = Integer.parseInt(reader.readLine());

        switch (exercise){
            case 2 -> Exercise02(connection);
            case 3 -> Exercise03(connection);
        }

    }

    private static void Exercise03(Connection connection) throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());
        String villainName = findEntityNameById("villains", villainId);

        System.out.println("Villain: " + villainName);
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT  m.name, m.age FROM minions m\n" +
                        "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                        "WHERE mv.villain_id = ?");

        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;

        while (resultSet.next())   {
            System.out.println((String.format("%d. %s %d",
                    ++counter,
                    resultSet.getString("name"),
                    resultSet.getInt("age"))));
        }
    }

    private static String findEntityNameById(String tableName, int entityId) throws SQLException {
        String query = String.format("SELECT  name FROM %s WHERE id = ?;", tableName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);
        preparedStatement.setInt(1, entityId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getString(1);
    }

    private static String findVillainNameById(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT  name FROM villains WHERE id = ?;");
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("name");
    }


    private static void Exercise02(Connection connection) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS`m_count` FROM villains v\n" +
                        "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                        "GROUP BY v.name\n" +
                        "HAVING m_count > ?;");

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.printf("%s - %d %n",
                    resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }

    //Get Connection method >
    private static Connection getConnection() throws IOException, SQLException {
        //Taking data for the database login
        System.out.println("Enter user:");
        String user = reader.readLine();
        System.out.println("Enter password:");
        String password = reader.readLine();

        //Appending the data into connection properties
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        return DriverManager
                .getConnection(CONNECTION_STRING + DB_NAME, properties);
    }
}
