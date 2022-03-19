import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", "root" ,"12345");
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the salary you want to search for:");
        double salary = Double.parseDouble(scanner.nextLine());

        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE salary > " + salary);

        while (resultSet.next()){
            String jobTitle = resultSet.getString(5);
            long id = resultSet.getLong(1);
            System.out.println(id + " | " + jobTitle);
        }

    }
}

