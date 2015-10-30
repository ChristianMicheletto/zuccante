package indovinanmultthr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**

 @author cognolato.samuel
 */
public class IndovinaNClientMT {

	/**
	 @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		String serverAddress = "127.0.0.1";
		PrintWriter out;
		BufferedReader in;
		BufferedReader stdIn;
		boolean continua = true;
		boolean valid;
		boolean inPartita;
		String risposta = "";
		
		Socket socket = new Socket(serverAddress, 8080);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(in.readLine());
		while (continua){
			System.out.println(in.readLine());
			inPartita = true;
			while (inPartita){
				out.println(stdIn.readLine());
				risposta = in.readLine();
				System.out.println(risposta);
				inPartita = !(risposta.equals("Indovinato!")||
							  risposta.equals("Vite terminate"));
			}
			valid = false;
			System.out.println(in.readLine());
			while (!valid){
				out.println(stdIn.readLine());
				risposta = in.readLine();
				valid = !risposta.equals("Risposta non valida");
				System.out.println(risposta);
			}
			continua = risposta.equals("nuova partita");
		}
		
		socket.close();
	}
	
}
