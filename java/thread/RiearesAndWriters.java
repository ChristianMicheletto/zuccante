import java.util.Random;
import java.util.concurrent.*;

public class ReadersAndWriters {
    	
    private static ReadersAndWriters raw;
    private static Thread t1, t2, t3, t4, t5;
    private static final Random rand = new Random();
    private static Semaphore sm = new Semaphore(2);
    
    String text = "Beginning of the Book";
    
    private void busy() {
        try {
            Thread.sleep(rand.nextInt(1000)+1000);
        } catch (InterruptedException e){
            e.printAtackTrace();
        }
    }
    	
    void write(String sentence){
        System.out.println(Thread.currentThread().getName() +" started to WRITE");
        text += "\n" + sentence;
        System.out.println(text);
        System.out.println("End of Book\n");
        System.out.println(Thread.currentThread().getName() +" finished WRITING");
    }
    	
    void read(){
        System.out.println("\n"+Thread.currentThread().getName() +" started to READ");
        //System.out.println(text);
        //System.out.println("End of Book\n");
    }
    	
    private class Writer implements Runnable {
        ReadersAndWriters rw;
        
        Writer (String name, ReadersAndWriters rw) {
            super();
            this.rw=rw;
        }
        
        public void run() {
            while (true) {
                busy();	
                //sm.acquire();
                String new_sentence = new String("\tnew line in Book");
                ts.write(new_sentence);
                //sm.release();
            } // of while
        }
    }
    
    private class Reader implements Runnable {
        ThreadSync ts;
        Reader (String name, ThreadSync ts) {
    			super();
    			this.ts=ts;
    		}
    		public void run() {
    			while (true) {
    				sm.acquire();
    				//System.out.print(t);
    				sm.release();
    				busy();
    				ts.read();
    			} // of while
    		}
    	}
    public void startThreads() {
    	ThreadSync ts = new ThreadSync();
    	t1 = new Thread(new Writer("Writer # 1", ts));
    	t2 = new Thread(new Reader("Reader # 1", ts));
    	//t3 = new Thread(new Reader("Writer # 2", ts));
    	//t4 = new Thread(new Reader("Reader # 2", ts));
    	//t5 = new Thread(new Reader("Reader # 3", ts));
    	t1.start();
    	t2.start();
    	//t3.start();
    	//t4.start();
    	//t5.start();
    }
    public static void main(
    	String [] args) {
    	thrdsync = new ThreadSync();
    	System.out.println("Lets begin...\n");
    	thrdsync.startThreads();
    	}
    }
