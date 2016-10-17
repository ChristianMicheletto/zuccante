import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
    
    private static String dbName = "shop.sqlite";
    
    public static void main(String[] args) throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            // create a database connection (side effect create DB)
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            /* complete it
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("DROP TABLE IF EXISTS Products");
            statement.executeUpdate("CREATE TABLE ... ");
            statement.executeUpdate("INSERT INTO ... ");
            statement.executeUpdate("INSERT INTO ... ");
            */
      
        } catch(SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if(connection != null)
                connection.close();
            } catch(SQLException e){
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}



/* old version

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
*/
