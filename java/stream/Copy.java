import java.io.*;

public class Copy {
    
    public static void main(String[] args){
        
        String s, file;
        BufferedReader standard = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out = null;
        
        // checks arguments number
        if (args.length >= 1) file = args[0];
        else file = "parappa.txt";
        // open the file name
        try {
            out = new FileOutputStream(file);
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
                if(s.compareTo("fine") == 0){
                    System.out.println("FINE");
                    out.close();
                    standard.close();
                    System.exit(0);
                }
            } catch (IOException e){
                System.out.println("I/O error");
                System.exit(0);
            }
        }
    }
}
