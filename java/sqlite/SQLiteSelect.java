import java.sql.*;


/* note: set CLASSPATH in order to find the driver */


public class SQLiteSelect {
    
    public static void showAll(ResultSet rs) throws SQLException {
         while (rs.next()) {
                int id = rs.getInt("_id");
                String  name = rs.getString("name");
                String  description = rs.getString("description");
                float price = rs.getFloat("price");
                System.out.println("_id = " + id); 
                System.out.println("name = " + name);
                System.out.println("description = " + description);
                System.out.println("price = " + price);   
                System.out.println("************************************************");
            }
        }
        
    
    public static void main( String args[] ) throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shop.sqlite");
            // c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Products;" );
            System.out.println("try SELECT");
            try {
                showAll(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
       }
       System.out.println("Operation done successfully");
    }
}
