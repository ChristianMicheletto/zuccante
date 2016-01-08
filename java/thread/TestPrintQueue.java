import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class TestPrintQueue {
    
    public static void main (String args[]){
        
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i=0; i<10; i++){
            thread[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}



class Job implements Runnable {
    
    private PrintQueue printQueue;
    
    public Job(PrintQueue printQueue){
       this.printQueue = printQueue;
    }
    
    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
        
    
    
class PrintQueue {
    
    static final Random random = new Random((new Date()).getTime());
    
    private final Semaphore semaphore;
    
    public PrintQueue(){
        semaphore = new Semaphore(1);
    }
    
    public void printJob (Object document){
        try {
            semaphore.acquire();
            int duration = 1 + random.nextInt(4);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
            Thread.currentThread().getName(),duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
