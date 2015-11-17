import java.io.*; // here File class
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*; // for annotation
import java.util.LinkedHashMap;
import java.util.Map;


/* in web.xml

<multipart-config>
    <location>/tmp</location>
    <max-file-size>20848820</max-file-size>
    <max-request-size>418018841</max-request-size>
    <file-size-threshold>1048576</file-size-threshold>
</multipart-config>
*/

// servlet annotations
@WebServlet(
        name = "uploadServlet",
        urlPatterns = {"/upload"},
        loadOnStartup = 1
)

@MultipartConfig(
        // The file size in bytes after which the file will be temporarily stored on disk (default 0)
        fileSizeThreshold = 5_242_880, //5MiB
        // The maximum size allowed for uploaded files, in bytes. 
        // If the size of any uploaded file is greater than this size, 
        // the web container will throw an exception (IllegalStateException). 
        // The default size is unlimited.
        maxFileSize = 20_971_520L, //20MiB
        // An absolute path to a directory on the file system
        location = "/tmp",
        // The maximum size allowed for a multipart/form-data request, in byte
        // Es: 4 file * 20 MiB
        maxRequestSize = 41_943_040L //40MiB
)

public class Servlet007 extends HttpServlet {
    
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "upload/uploadFiles";
     
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) 
            throws ServletException, IOException {
        
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        // String savePath = appPath + "/" + SAVE_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        // getParts(): returns a collection of Part objects
        for (Part part: request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }
 
        request.setAttribute("message", "Upload has been done successfully!");
        // in order to use a relative path
        // forward a request to /message.jsp
        getServletContext().getRequestDispatcher("/upload/message.jsp").forward(
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
