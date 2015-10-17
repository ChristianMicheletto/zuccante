import java.sql.*;

public class SQLiteJDBC {
    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shp.sqlite");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cannot load driver");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Opened database successfully");
    }
}
