import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 
import javax.servlet.annotation.*; 

@WebServlet(
    name = "profile",
    urlPatterns = {"/ProfileServlet", "/profile"}
)

public class ProfileServlet extends HttpServlet {  
    
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
          
        HttpSession session = request.getSession(false);  
        if(session!=null){  
            String name=(String)session.getAttribute("name");  
            out.print("Hello, "+ name + " Welcome to Profile");  
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
    
    @Override
    public void destroy() {
      // do nothing.
    }
}  
