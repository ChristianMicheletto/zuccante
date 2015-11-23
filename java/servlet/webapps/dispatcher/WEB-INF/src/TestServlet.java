import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "dispatcher",
    urlPatterns = {"/TestServlet", "/try"}
)

public class TestServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                  throws ServletException, IOException 
    {
		performTask(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) 
                  throws ServletException, IOException 
    {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request, 
                             HttpServletResponse response) 
                     throws ServletException, IOException 
    {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("TestServlet says hi<br/>");

		String action = request.getParameter("action");
		if (action != null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			if ("include".equalsIgnoreCase(action)) {
				rd.include(request, response);
			} else if ("forward".equalsIgnoreCase(action)) {
				rd.forward(request, response);
			}
		}
	}
    
    @Override
    public void destroy() {
      // do nothing.
    }
}
