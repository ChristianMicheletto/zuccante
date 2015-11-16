import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*; // for annotation

// servlet annotation s
// NB metadata-complete="false" in web.xml
@WebServlet(
    name = "listner02",
    urlPatterns = {"/listener02"}
)

public class Servlet006 extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }

    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String dog = (String) session.getAttribute("dog");
        String name = (String) session.getAttribute("name");
            
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Parameters</title>\r\n")
              .append("  </head>\r\n")
              .append("  <body>\r\n")
              .append(name).append(" is a ").append(dog).append("\r\n")
              .append("  </body>\r\n")
              .append("</html>\r\n");
              session.invalidate();
    }
    
    @Override
    public void destroy() {
      // do nothing.
    }
}
