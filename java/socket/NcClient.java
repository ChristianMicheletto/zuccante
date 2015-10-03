import java.io.*;
import java.net.*;

public class NcClient {
    public static void main(String[] args) throws IOException {
		
		// usare nc -l 8888 per ascoltare, sarà il nostro server

        Socket ncSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        String address = "localhost";
        int port = 8888;

        try {
            ncSocket = new Socket(address, port);
            out = new PrintWriter(ncSocket.getOutputStream(), true); // autoflush, ecco il true
            in = new BufferedReader(new InputStreamReader(
                                        ncSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: localhost.");
            System.exit(1);
        }

	    BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	    String userInput;
	
	    System.out.println("... hai già lanciato il server \"netcat -l 8888\" e quindi procedi ...");
	    while ((userInput = stdIn.readLine()) != null) {
	        out.println("recive: " + userInput);
	        System.out.println("netcat -l: " + in.readLine());
	    }
	    out.close();
	    in.close();
	    stdIn.close();
	    ncSocket.close();
    }
}
