import java.io.*;
import java.sql.*;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
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

public class Servlet009 extends HttpServlet {
    
    @Resource(name = "jdbc/sqlite/shop")
    private DataSource dataSource;
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }
 
    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter writer = response.getWriter();
        try {
            Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Products";
            ResultSet rs = statement.executeQuery(sql);
            // pass to a jsp, no setParameter()
            request.setAttribute("resultSet", rs);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/sqlite.jsp");
            rd.forward(request, response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        } 
    }
 
}
