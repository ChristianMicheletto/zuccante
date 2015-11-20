import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import javax.servlet.annotation.*;

@WebServlet(
    name = "logout",
    urlPatterns = {"/LogoutServlet", "/logout"}
)

public class LogoutServlet extends HttpServlet {  
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }
    
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response)  
               throws ServletException, IOException {  
            
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
        HttpSession session = request.getSession();  
        // Invalidates this session then unbinds any objects bound to it.
        session.invalidate();  
        out.print("You are successfully logged out!");  
        out.close();  
    }  
    
    @Override
    public void destroy() {
      // do nothing.
    }
}  
