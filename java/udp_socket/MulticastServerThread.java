import java.io.*;
import java.net.*;
import java.util.*;

 
public class MulticastServerThread extends QuoteServerThread {
 
    private static long FIVE_SECONDS = 5000;
    static final int PORT = 4446;
    
    protected MulticastSocket socket = null; // out
    protected BufferedReader in = null; // in
    protected boolean moreQuotes = true;
    
    private static final Random rnd = new Random(System.currentTimeMillis());
 
    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Could not open quote file. Serving time instead.");
        }
    }
 
    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];
 
                // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();
 
                // send it
                // 224.0.0.1: All Hosts multicast group addresses all hosts on the same network segment
                InetAddress group = InetAddress.getByName("224.0.0.1"); 
                socket = new MulticastSocket(PORT);
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, PORT);
                socket.send(packet);
 
            // sleep for a while
        try {
            sleep(rnd.nextInt(2) * FIVE_SECONDS);
        } catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
        }
    socket.close();
    }
    
     protected String getNextQuote() {
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "No more quotes. Goodbye.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            returnValue = "IOException occurred in server.";
        }
        return returnValue;
    }
    
}
