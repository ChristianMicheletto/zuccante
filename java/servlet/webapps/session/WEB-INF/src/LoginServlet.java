import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import javax.servlet.annotation.*;

@WebServlet(
    name = "login",
    urlPatterns = {"/LoginServlet", "/login"}
)

public class LoginServlet extends HttpServlet {  
    
    @Override
    public void init() throws ServletException {
        // do required initialization
    }
    
    @Override
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response)  
                throws ServletException, IOException { 
                        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();  
        // the control remain in this servlet ... not as forward()
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name = request.getParameter("name");  
        String password = request.getParameter("password");  
          
        if (password.equals("admin123")){  
            out.print("Welcome, " + name);  
            HttpSession session = request.getSession();  
            session.setAttribute("name", name);  
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
    
    @Override
    public void destroy() {
      // do nothing.
    }
}  
