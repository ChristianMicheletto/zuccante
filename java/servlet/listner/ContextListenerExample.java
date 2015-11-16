import javax.servlet.*;
import javax.servlet.annotation.*;

// use catalina.sh run to see terminal of tomcat

@WebListener // annotation
public class ContextListenerExample implements ServletContextListener { 
    
    public void contextInitialized(ServletContextEvent e){ 
        ServletContext context = e.getServletContext(); 
        context.setAttribute("user", "pippo"); 
    } 
    
    public void contextDestroyed(ServletContextEvent e){ 
        System.out.println("Destroyed"); 
    } 
}

