import java.sql.*;

public class SQLiteQuery {
    
    public static void showAll(ResultSet rs) throws Exception {
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
        System.out.print("\n\n\n");
    }
        
    
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shop.sqlite");
            // c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            
            System.out.println("try SELECT");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Products;" );            
            showAll(rs);
            
            System.out.println("UPDATE Products SET name = \"briciole\" WHERE _id = 1;");
            stmt.executeUpdate( "UPDATE Products SET name = \"briciole\" WHERE _id = 1;" );
            System.out.print("\n\n\n");
            // c.commit();
            
            System.out.println("try SELECT");
            rs = stmt.executeQuery( "SELECT * FROM Products;" );            
            showAll(rs);
            
            System.out.println("DELETE FROM Products WHERE _id = 1;");
            stmt.executeUpdate( "DELETE FROM Products WHERE _id = 1;" );
            System.out.print("\n\n\n");
            
            System.out.println("try SELECT");
            rs = stmt.executeQuery( "SELECT * FROM Products;" );            
            showAll(rs);
            
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
       }
       System.out.println("Operation done successfully");
    }
}
