import java.net.*;
import java.io.*;


public class HTTPClient {
    
    final static int PORT = 80;

    public static void main(String[] args) {
        
        int port = PORT;
        
        if (args.length == 0) {
            System.out.println("HTTPClient http://localhost");
            System.exit(1);
        }
        
        for (int i = 0; i < args.length; i++) {
            try {
                URL    url = new URL(args[i]);
                if (url.getPort() != -1) port = url.getPort();
                if (!(url.getProtocol().equalsIgnoreCase("http"))) {
                    System.err.println("Sorry. I only understand http.");
                    continue;
                    }
                // client
                Socket s = new Socket(url.getHost(), port);
                OutputStream theOutput = s.getOutputStream();
                // no auto-flushing
                PrintWriter pw = new PrintWriter(theOutput, false);
                // native line endings are uncertain so add them manually
                // \n\r ending HTTP lines
                pw.print("GET " + url.getFile() + " HTTP/1.0\r\n");
                pw.print("Accept: text/plain, text/html, text/*\r\n");
                pw.print("\r\n");
                // send message
                pw.flush();
                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                int c;
                while ((c = br.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                System.err.println(args[i] + " is not a valid URL");
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println(ex);
            }
       }
    }
}
