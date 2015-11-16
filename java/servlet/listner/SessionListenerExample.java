import javax.servlet.*;
import javax.servlet.http.*; // here HttpSessionListener
import javax.servlet.annotation.*;

// use catalina.sh run to see terminal of tomcat

@WebListener // annotation
public class SessionListenerExample implements HttpSessionListener {
    
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        // Get the session that was created
        HttpSession session = hse.getSession();
        // Store something in the session, and log a message
        try {
            System.out.println("Session created: " + session);
            session.setAttribute("dog", "bastard");
            session.setAttribute("name", "Jentsy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        // Get the session that was invalidated
        HttpSession session = sessionEvent.getSession();
        // Log a message
        System.out.println("Session invalidated: " + session);
        System.out.println("The breed of the dog is : " + session.getAttribute("dog"));
        System.out.println("The name of the dog is : " + session.getAttribute("name"));
    }
}
