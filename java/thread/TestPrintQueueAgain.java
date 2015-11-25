import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock; // interface
import java.util.concurrent.locks.ReentrantLock; 



public class TestPrintQueueAgain {
    
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
    private boolean freePrinters[];
    private Lock lockPrinters;
    
    public PrintQueue(){
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i=0; i<3; i++){
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }
    
    public void printJob (Object document){
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            int duration = 1 + random.nextInt(4);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
            Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
    
    private int getPrinter() {
        int ret = -1;
        try {
            // start critical section: take the shared resource
            lockPrinters.lock();
            for (int i=0; i<freePrinters.length; i++) {
                if (freePrinters[i]){
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // end critical section
            lockPrinters.unlock();
        }
        return ret;
    }
}
