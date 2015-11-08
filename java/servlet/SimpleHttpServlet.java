import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleHttpServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // GRT request
        response.getWriter().write("<html><body>GET response</body></html>");
    }
}
