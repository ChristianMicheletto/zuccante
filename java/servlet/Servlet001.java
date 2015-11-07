import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet001 extends HttpServlet {
    
    private static final String DEFAULT_USER = "Guest";
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }

    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        String user = request.getParameter("user");
        if(user == null) 
            user = DEFAULT_USER;
        // Set response content type and character encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Actual logic goes here.
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n") //note HTML5
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Hello User Application</title>\r\n")
              .append("  </head>\r\n")
              .append("  <body>\r\n")
              .append("    Hello, ").append(user).append("!<br/><br/>\r\n")
              .append("    <form action=\"Servlet001\" method=\"POST\">\r\n")
              .append("        Enter your name:<br/>\r\n")
              .append("        <input type=\"text\" name=\"user\"/><br/>\r\n")
              .append("        <input type=\"submit\" value=\"Submit\"/>\r\n")
              .append("    </form>\r\n")
              .append("  </body>\r\n")
              .append("</html>\r\n");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response)
                throws ServletException, IOException
    {
        this.doGet(request, response);
    }
  
    public void destroy() {
      // do nothing.
    }
}
