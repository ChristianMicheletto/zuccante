import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet003 extends HttpServlet {
    
    private String user;
    private String password;
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }

    @Override
    public void doGet(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException
    {
        // ServletContest can be obtained from ServletConfig called 
        // during initialization
        // There is one context per "web application" per Java Virtual Machine
        // see war files ....
        ServletContext c = this.getServletContext();
        user = c.getInitParameter("user");
        password = c.getInitParameter("password");
        if(user == null) user = "pinco";
        if(password == null) password = "pwdpinco";
            
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("  <head>\r\n")
              .append("    <title>Parameters</title>\r\n")
              .append("  </head>\r\n")
              .append("  <body>\r\n")
              .append("    user is: ").append(user).append("<br />\r\n")
              .append("    password is: ").append(password).append("<br />\r\n")
              .append("  </body>\r\n")
              .append("</html>\r\n");
    }
    
    @Override
    public void destroy() {
      // do nothing.
    }
}
