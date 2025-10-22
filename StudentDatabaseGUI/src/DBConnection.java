import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/college_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "Arushi@1971"; 

    public static Connection getConnection() {
        try {
            // System.out.println("Connecting to database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}