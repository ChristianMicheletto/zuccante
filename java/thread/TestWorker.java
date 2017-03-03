import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestWorker {
    public static void main(String[] args) {
        // lambda 
        Runnable barrierAction = () -> System.out.println("We are ready.");
        CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);
        
        // System.out.println("getParties(): " + barrier.getParties()); 
        
        /** ... the same as 
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                                                     public void run() {
                                                         System.out.println("We are ready.");
                                                      }
                                                  });
        */
        for (int i = 1; i <= 3; i++) {
            Worker w = new Worker(i, barrier);
            Thread t = new Thread(w);
            t.start();
        }
    }
}

class Worker implements Runnable {
    
    private CyclicBarrier barrier;
    private int ID;
    private static Random random = new Random();

    public Worker(int ID, CyclicBarrier barrier) {
      this.ID = ID;
      this.barrier = barrier;
    }
  
    @Override
    public void run() {
        try {
            int workTime = random.nextInt(30) + 1;
            System.out.println("Thread #" + ID + " is going to work for " + workTime + "  seconds");
            Thread.sleep(workTime * 1000);
            System.out.println("Thread #" + ID + " is waiting at the barrier.");
            System.out.println("getNumberWaiting(): " + barrier.getNumberWaiting()); 
            barrier.await();
            System.out.println("Thread #" + ID + " passed the barrier.");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          System.out.println("Barrier is broken.");
        }
    }
}
