import java.net.*;
import java.io.*;
import java.util.Date;

public class DayTimeServer {
    public final static int PORT = 9999;
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("use \"netcat -v localhost 9999\"");
            while (true) {
                try (Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() +"\r\n"); // for windows
                    out.flush();
                    connection.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
