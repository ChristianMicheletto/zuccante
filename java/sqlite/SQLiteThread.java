import java.sql.*;

public class SQLiteThread {
    
    public static Connection conn;
    
   public static void main(String[] args) throws Exception {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:shop.sqlite");
      System.out.println("Opened database successfully and eventually created");

      Statement stat = conn.createStatement();
      stat.executeUpdate("DROP TABLE IF EXISTS Products");
      stat.executeUpdate("CREATE TABLE Products (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, description TEXT NOT NULL, price FLOAT NOT NULL  DEFAULT 0.5)");

      SqlTask tasks1[] = {
         new SqlTask("Pane nero", "pane integrale"),
         new SqlTask("Patatine al ketchup", "patatine artigianali della casa"),
         new SqlTask("Biscotti al cioccolato", "biscotti secchi con gocce di cioccolato"),
         new SqlTask("Frollini plus", "frollini")
      };
      
      SqlTask tasks2[] = {
         new SqlTask("Gioppini", "gustosi e croccanti"),
         new SqlTask("Merendine", "con confettura di albicocche"),
         new SqlTask("Biscotti al limone", "biscotti con aroma limone"),
         new SqlTask("Frollini plus 2", "frollini dietetici")
      };

      System.out.println("TEST1: sequential DB access:");

      Thread threads[] = new Thread[tasks1.length];
      for(int i = 0; i < tasks1.length; i++)
         threads[i] = new Thread(tasks1[i]);

      for(int i = 0; i < tasks1.length; i++) {
         threads[i].start();
         threads[i].join();
      }

      System.out.println("Concurrent DB access:");

      for(int i = 0; i < tasks2.length; i++)
         threads[i] = new Thread(tasks2[i]);

      for(int i = 0; i < tasks2.length; i++)
         threads[i].start();

      for(int i = 0; i < tasks2.length; i++)
         threads[i].join();
    
  
   }


   private static class SqlTask implements Runnable {
      String name;
      String description;

      public SqlTask(String name, String description) {
         this.name = name;
         this.description = description;
      }

      @Override 
      public void run() {
         // Connection conn = null;
         PreparedStatement prep = null;
         long startTime = System.currentTimeMillis();

         try {
            try {
               // conn = DriverManager.getConnection("jdbc:sqlite:shop.sqlite");
               prep = conn.prepareStatement("INSERT INTO Products(name, description) VALUES (?, ?)");

               prep.setString(1, name); // first ?
               prep.setString(2, description); // second ?
               // execute DML query
               prep.executeUpdate();

               long duration = System.currentTimeMillis() - startTime;
               System.out.println("*** INSERTED: " + name + ", " + description +  "\n::: duration: " + duration);
            }
            finally {
               if (prep != null) prep.close();
               // if (conn != null) conn.close();
            }
         }
         catch(SQLException e) {
            long duration = System.currentTimeMillis() - startTime;
            System.out.print("SQL Insert failed: " + duration);
            System.out.println(" SQLException: " + e);
         }
      }
   }
}

/****** COMMENTO FINALE ********************************
 * 
 * La lentezza del metodo non sequenziale non è di Java ma di
 * SQLite, infatti, realizzato in C,
 * i lock vengono realizzati mediante il classico lock su file ed i
 * thread vengono, così parrebbe, gestiti come processi
 */


