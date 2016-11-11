import java.io.*;
import java.net.*;
import java.util.*;

 
public class MulticastServerThread extends QuoteServerThread {
 
    private long FIVE_SECONDS = 5000;
    
    private static final Random rnd = new Random(System.currentTimeMillis());
 
    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
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
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
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
}
