package indovinanmultthr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**

 @author cognolato.samuel
 */
public class IndovinaNServerMT {
	
    private static final ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    
    public static void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
    }
    
    private static class Task implements Runnable {
        
		protected Socket client;
		protected Random random;
		
        public Task(Socket socket, Random random){
            client = socket;
			this.random = random;
        }
        
        @Override
        public void run() {
			PrintWriter out = null;
			BufferedReader in = null;
			try {
				out = new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(
					 new InputStreamReader(client.getInputStream()));
				boolean replay = true;
				out.println("Connesso al server");
				while (replay){
					int n = random.nextInt(100);
					int nRisposta;
					boolean finePartita = false;
					String risposta;
					String esito;
					int nVite = 5;
					System.out.println(n);
					out.println("Indovina il numero");
					while (!finePartita){
						risposta = in.readLine();
						try{
							nRisposta = Integer.parseInt(risposta);
							if (n>nRisposta){
								nVite--;
								esito = nVite<0 ? "Vite terminate":
									"Il numero da indovinare è più alto";
								
							}
							else if (n<nRisposta){
								nVite--;
								esito = nVite<0 ? "Vite terminate":
									"Il numero da indovinare è più basso";
							}
							else{
								esito = "Indovinato!";
								finePartita = true;
							}
							if (esito.equals("Vite terminate")) finePartita = true;
						}
						catch(NumberFormatException e){
							esito = "Risposta non valida";
						}
						out.println(esito);
					}
					boolean valid = false;
					out.println("Vuoi giocare ancora? (s/n)");
					while (!valid){
						risposta = in.readLine();
						switch (risposta) {
							case "s":
								valid = true;
								replay = true;
								nVite = 5;
								esito = "nuova partita";
								break;
							case "n":
								valid = true;
								replay = false;
								esito = "fine gioco";
								break;
							default:
								valid = false;
								esito = "Risposta non valida";
								break;
						}
						out.println(esito);
					}

				}
				in.close();
				out.close();
			} catch (IOException ex) {}
        }
	}
	
	public static void endServer() {
        executor.shutdown();
    }
    
    public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket (8080);
			Random random = new Random ((new Date()).getTime());
			while(true){
				Socket client = server.accept();
				Task task = new Task(client, random);
				executeTask(task);
			}
		} catch (IOException ex) {}
    }
}
