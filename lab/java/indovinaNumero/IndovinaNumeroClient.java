import java.io.*;
import java.net.*;
import java.util.Scanner;

public class IndovinaNumeroClient implements Messaggi {
    
    static final String SERVER = "127.0.0.1";
    static final int PORT = 9090;
    static String feedBack;
    

	public static void main(String[] args) {
		try {
			Socket server = new Socket(SERVER, PORT);
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
				PrintWriter out = new PrintWriter(server.getOutputStream(), true); // with autoflush
                Scanner s = new Scanner(System.in);
                // show message
                System.out.println(in.readLine());
				while (true) {
					System.out.println(in.readLine());
                    // in case .. try & catch
					out.println(s.nextInt());
					feedBack = in.readLine();
					System.out.println(feedBack);
					if (feedBack == Messaggi.OK) break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
            System.out.println("Il server è spento");
			// e.printStackTrace();
		} 
	}
}
