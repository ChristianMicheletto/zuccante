import java.sql.*;

public class SQLiteJDBC {
    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Opened database successfully");
    }
}
