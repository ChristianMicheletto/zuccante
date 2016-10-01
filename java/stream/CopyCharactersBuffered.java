import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.IOException;

public class CopyCharactersBuffered {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("canto.txt"));
            outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));

            String s;
            while ((s = inputStream.readLine()) != null) {
                outputStream.write(s,0,s.length());
                outputStream.write("\n",0,1);
                outputStream.flush(); //try to remove
                // System.out.println(s); // check
            }
        } catch(IOException e) {
            e.printStackTrace();
        } // AutoCloseable
    }
}
