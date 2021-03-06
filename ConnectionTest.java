import java.sql.*;
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.err.println(e.getMessage());
            return;
        }
        Connection con = null;
        try {
            /*con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/I4GIC2021",
                    "i42021_user","123456");
              stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                    "`counters`(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "`count` INT, `note` VARCHAR(100))");
                System.out.println("Table counters is created.");*/
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/",
                    "root","");
            System.out.println("Connection successful!");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE `Bank`");
            System.out.println("Database Bank is created.");
            stmt.executeUpdate("GRANT ALL PRIVILEGES ON `Bank`.* TO `user1`@`localhost`");
            System.out.println("User user1 is created with password 123456.");
            stmt.executeUpdate("use Bank");
            System.out.println("Database changed to Bank.");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                    "`counters`(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "`count` INT, `note` VARCHAR(100))");
            System.out.println("Table counters is created.");
            stmt.executeUpdate("Insert into `counters`(`count`,`note`) values(100,'A Hundred')");
            System.out.println("Data is inserted.");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(con != null) con.close();
        }
    }
}