import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Random;

public class IndovinaNumeroServer implements Messaggi {

	static Random r = new Random(new Date().getTime());
	
	// set tries number
	final static int TRIES = 10;
    // il numero massimo
    final static int MAX = 10;
    // set port
    final static int PORT = 9090;

	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(PORT);
		System.out.println("Running server a port: " + PORT);
		try {
			while (true) {
				Socket client = listener.accept();
                System.out.println("Connection accepted from: " + client.getInetAddress());
                int numServer = r.nextInt(MAX + 1); 
                boolean indovinato = false;
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter out = new PrintWriter(client.getOutputStream(), true); // with autoflush
					// start game
                    out.println(Messaggi.WELCOME);
					System.out.println(numServer);
					for (int i = 1; !indovinato && i <= TRIES; i++) {
						out.println(Messaggi.TRY + i);
                        // da inserire in un try & catch: throws NumberFormatException
						int numClient = Integer.parseInt(in.readLine());
						System.out.println(numClient);
						if (numClient == numServer) {
							out.println(Messaggi.OK);
							indovinato = true;
						} else {
							if (numClient > numServer) {
								out.println(Messaggi.MINORE);
							}
							else {
								out.println(Messaggi.MAGGIORE);
							}
						}
					}
					if (!indovinato) {
						out.println(Messaggi.NOMORETRIES);
					} else {
						out.println(Messaggi.FINISH);
					}
				} catch (IOException e) {
				    e.printStackTrace();
                } finally {
                    // from Java 7 auto closing streams
					client.close();
				}
			}
		} finally {
			listener.close();
		}
	}
}
