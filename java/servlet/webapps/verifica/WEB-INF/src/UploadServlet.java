import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
 
@WebServlet(
        name = "upload",
        urlPatterns = {"/upload"}
)

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
                 
public class UploadServlet extends HttpServlet {
 
    // path
    private String schoolClassPath;
    private String lastNamePath;
     
    @Override
    public void init() throws ServletException {
    }
    
    @Override
    public void doPost( HttpServletRequest request,
                        HttpServletResponse response ) 
                 throws ServletException, IOException 
    {
        
        HttpSession session = request.getSession();
        String schoolClass = (String) session.getAttribute("school_class");
        String lastName = (String) session.getAttribute("last_name");
        // session.invalidate();
        // remove white spaces and capitalize
        schoolClass = schoolClass.toUpperCase().replaceAll("\\s+","");
        lastName = lastName.toLowerCase().replaceAll("\\s+","");
        if (schoolClassPath == "" || lastName == ""){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
        schoolClassPath = schoolClass;
        lastNamePath = lastName;
        
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String absClassSchoolPath = appPath + File.separator + schoolClassPath;
        String absStudentPath = absClassSchoolPath + File.separator + lastNamePath;
        
        
        File schoolClassDir = new File(absClassSchoolPath);
        if (!schoolClassDir.exists()) {
            schoolClassDir.mkdir();
        }
        
        File studentDir = new File(absStudentPath);
        while(studentDir.exists()){
            absStudentPath = absStudentPath + "Again";
            studentDir = new File(absStudentPath);
        }
        if (!studentDir.exists()) {
            studentDir.mkdir();
        }
        
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(absStudentPath + File.separator + fileName);
        }
 
        // request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/result.jsp").forward(
                request, response);
    }
 
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    
}
