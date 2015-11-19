import java.io.*;
import java.sql.*;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(
        name = "select",
        urlPatterns = {"/products"}
)

public class Servlet008 extends HttpServlet {
    
    @Resource(name = "jdbc/shop")
    private DataSource dataSource;
    
    String msg = "";
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }
 
    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Mari DB Test</title>\r\n")
              .append("        <style>")
              .append("h2 { color: #98bf21;}")
              .append("td { font-size: 1em; border: 1px solid #98bf21; padding: 3px 7px 2px 7px;}")
              .append("        </style>")
              .append("  </head>\r\n")
              .append("  <body>\r\n");
        try {
            
            Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();                
            String sql = "SELECT * FROM Products";
            ResultSet rs = statement.executeQuery(sql);
            
            writer.append("<h2> Products </h2>\r\n");
            writer.append("<table>\r\n");
            while (rs.next()) {
                writer.append("<tr>\r\n");
                writer.append(String.format("<td> %d </td><td> %s </td><td> %s </td>", 
                               rs.getInt("_id"), rs.getString("name"), rs.getString("description")));
                writer.append("<tr>\r\n");
            }
            writer.append("</table >\r\n")
                  .append("  </body>\r\n")
                  .append("</html>\r\n");
        
            // finalize
            rs.close();
            rs = null;
            statement.close();
            statement = null;
            conn.close(); // Return to connection pool
            conn = null;  // Make sure we don't close it twice
        } catch (SQLException ex) {
            writer.append("<bf> SQLException </bf>\r\n")
                  .append("  </body>\r\n")
                  .append("</html>\r\n");
        } catch (Exception e) {
            writer.append("<bf> Exception </bf>\r\n")
                  .append("  </body>\r\n")
                  .append("</html>\r\n");
        }
    }
 
}
