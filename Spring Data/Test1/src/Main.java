import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException,
            IOException ,ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/soft_uni", "root", "Escape93bg!")){
            Scanner scan = new Scanner(System.in);
            double salary = Double.parseDouble(scan.nextLine());

            Statement stmnt = connection.createStatement();
            ResultSet rs= stmnt.executeQuery("SELECT first_name, last_name FROM employees WHERE salary > " + salary);

            while (rs.next()){
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
    }
}
