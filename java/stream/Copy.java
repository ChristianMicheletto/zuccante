import java.io.*;

public class Copy {
    
    public static void main(String[] args){
        
        String s;
        BufferedReader standard = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out = null;
        
        // checks arguments number
        if (args.length!=1) System.exit(0);
        // open the file name
        try {
            out = new FileOutputStream(args[0]);
        } catch (FileNotFoundException e){
            System.exit(0);
        }
        // users have to leave by using Control-C
        while(true){
            try {
                // read and write
                s = standard.readLine();
                out.write(s.getBytes());
                out.write("\n".getBytes());
            } catch (IOException e){
                System.out.println("I/O error");
                System.exit(0);
            }
        }
    }
}
