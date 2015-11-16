import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*; // for annotation

// servlet annotation s
// NB metadata-complete="false" in web.xml
@WebServlet(
    name = "listner01",
    urlPatterns = {"/listener01"}
)

public class Servlet005 extends HttpServlet {
    
    private String user;
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }

    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext context = this.getServletContext();
        user = (String)context.getAttribute("user");
            
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Parameters</title>\r\n")
              .append("  </head>\r\n")
              .append("  <body>\r\n")
              .append("    user: ").append(user).append("\r\n")
              .append("  </body>\r\n")
              .append("</html>\r\n");
    }
    
    @Override
    public void destroy() {
      // do nothing.
    }
}
