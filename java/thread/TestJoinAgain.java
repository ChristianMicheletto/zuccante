import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestJoinAgain {
  
    public static void main(String args[]) throws InterruptedException {
      
        System.out.println(Thread.currentThread().getName() + " is Started");
      
        Thread t1 = new Thread(new SimpleTask(4));
        Thread t2 = new Thread(new SimpleTask(6));
        Thread t3 = new Thread(new SimpleTask(8));
        
        Thread t4 = new Thread(new SimpleTask(4));
        Thread t5 = new Thread(new SimpleTask(6));
        Thread t6 = new Thread(new SimpleTask(8));
        
        System.out.println("sequence of threads... ");
        
        t1.start();
        // in main it works also without try and carch
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        
        System.out.println("concurrent threads... ");
        t4.start();
        t5.start();
        t6.start();
        t4.join();
        t5.join();
        t6.join();
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
    }
}

class SimpleTask implements Runnable {
    
    int n;
    
    public SimpleTask(int n) {
        this.n = n;
    }
    
    @Override
    public void run() {
        System.out.printf("START: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.printf("STOP: %s\n", new Date());
    }
}
