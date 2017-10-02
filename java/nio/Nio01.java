import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class Nio01 {
    
    public static void main(String[] args) throws IOException {
        
        RandomAccessFile aFile = new RandomAccessFile("canto.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        
        ByteBuffer buf = ByteBuffer.allocate(48);
        
        int bytesRead = inChannel.read(buf); // number of bytes read
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            // The flip() method switches a Buffer from writing mode to reading mode
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear(); 
            // ... and the you can read the buffer
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}



