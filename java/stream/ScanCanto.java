import java.io.*;
import java.util.Scanner;

public class ScanCanto {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        int n = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("canto.txt")));

            while (s.hasNext()) {
                System.out.println((++n) + "\t" + s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
