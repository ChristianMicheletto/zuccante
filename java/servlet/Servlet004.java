import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*; // for annotation

// servlet annotation s
// NB metadata-complete="false" in web.xml
@WebServlet(
    name = "parametersTest",
    urlPatterns = {"/Servlet004", "/parameters"},
    initParams = {
        @WebInitParam(name = "database", value = "test"),
        @WebInitParam(name = "server", value = "10.0.12.5")
    }
)

public class Servlet004 extends HttpServlet {
    
    private String database;
    private String server;
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }

    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        // A servlet configuration object used by a servlet container 
        // to pass information to a servlet 
        // during initialization.
        ServletConfig c = this.getServletConfig();
        server = c.getInitParameter("server");
        database = c.getInitParameter("database");
            
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Parameters</title>\r\n")
              .append("  </head>\r\n")
              .append("  <body>\r\n")
              .append("    database: ").append(server).append(":").append(database).append("\r\n")
              .append("  </body>\r\n")
              .append("</html>\r\n");
    }
    
    @Override
    public void destroy() {
      // do nothing.
    }
}
