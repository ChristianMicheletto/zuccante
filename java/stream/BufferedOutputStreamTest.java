import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BufferedOutputStreamTest {
    
    public static void main(String[] args) {
        String filename = "output.txt";
        String output = "Ma mi no go capio 'sti stream!!!\n";
        BufferedOutputStream bos = null;
        
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filename));
            bos.write(output.getBytes());
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File not found" + fnfe);
        }
        catch (IOException ioe) {
            System.out.println("Error while writing to file" + ioe);
        }
        finally {
            try {
                if (bos != null) {
                    // bos.flush();
                    bos.close();
                }
            }
            catch (Exception e) {
                System.out.println("Error while closing streams" + e);
            }
        }
    }
}
            
