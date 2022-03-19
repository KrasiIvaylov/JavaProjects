import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Exercises {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String TABLE_NAME = "minions_db";
    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {
        /*
        Program would require username and password for your database and then exercise number in the given format:
        Enter user:
        root
        Enter password!
        12345
        Enter exercise number:
        2
        Output:
        - Flo 16
         */
        connection = getConnection(reader);
        System.out.println("Enter exercise number:");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 2 -> Exercise02();
            case 3 -> Exercise03();
            case 4 -> Exercise04();
            case 5 -> Exercise05();
            case 7 -> Exercise07();
            case 9 -> Exercise09();
        }
    }

    private static void Exercise09() {
    }

    private static void Exercise04() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO towns(name) values (?);");
    }

    private static void Exercise07() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT name FROM minions;");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> allMinionsNames = new ArrayList<>();
        while (resultSet.next()){
            allMinionsNames.add(resultSet.getString(1));
        }
        int start = 0;
        int end = allMinionsNames.size() - 1;
        for (int i = 0; i < allMinionsNames.size(); i++) {
            System.out.println(i % 2 == 0
                    ? allMinionsNames.get(start++)
                    : allMinionsNames.get(end--));
        }
    }

    private static void Exercise05() throws IOException, SQLException {
        System.out.println("Enter country name:");
        String countryName = reader.readLine();
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        preparedStatement.setString(1, countryName);
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0){
            System.out.println("No town names");
            return;
        }
        System.out.println(String.format("%d town names were affected!", affectedRows));
        PreparedStatement preparedStatementTowns = connection
                .prepareStatement("SELECT name FROM towns WHERE country = ?;");
        preparedStatementTowns.setString(1, countryName);
        ResultSet resultSet = preparedStatementTowns.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s ", resultSet.getString("name"));
        }
    }

    private static void Exercise03() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());
        String villainName = findVillainNameById(villainId);
        System.out.println("Villain: " + villainName);
        //Set<String> result = new LinkedHashSet<>();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT m.name, m.age FROM minions m\n" +
                        "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                        "WHERE mv.villain_id = ?;");
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;
        while (resultSet.next()){
            System.out.printf("%d. %s %d%n",
                    ++counter,
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            );
        }
    }

    private static Set<String> getAllMinionsByVillainId(int villainId) throws SQLException {

        return null;
    }

    private static String findVillainNameById(int villainId) throws SQLException {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT name FROM villains WHERE id = ?;");
            preparedStatement.setInt(1, villainId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString("name");

    }

    private static void Exercise02() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS 'm_count' FROM villains v\n" +
                        "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                        "GROUP BY v.name\n" +
                        "HAVING `m_count` > ?;");

        preparedStatement.setInt(1, 15);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Output:");
            System.out.printf("- %s %d %n", resultSet.getString(1),
                    resultSet.getInt(2));
        }

    }

    private static Connection getConnection(BufferedReader reader) throws IOException, SQLException {
        System.out.println("Enter user:");
        String user = reader.readLine();
        System.out.println("Enter password!");
        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        return DriverManager
                .getConnection(CONNECTION_STRING + TABLE_NAME, properties);
    }
}
