public class TestCounter {
   public static void main(String args[]) {

      Counter c = new Counter();

      ThreadDemo t1 = new ThreadDemo("Thread - 1 ", c);
      ThreadDemo t2 = new ThreadDemo("Thread - 2 ", c);

      t1.start();
      t2.start();

      // wait for threads to end
      try {
         t1.join();
         t2.join();
      } catch(InterruptedException e) {
          System.out.println("Interrupted");
      }
   }
}

class Counter {
    public void printCount(){
    try {
         for(int i = 5; i > 0; i--) {
            System.out.printf("%s: counter => %d \n", Thread.currentThread().getName(), i);
         }
     } catch (Exception e) {
         System.out.println("Thread interrupted.");
     }
   }

}

class ThreadDemo extends Thread {
    Counter counter;

    ThreadDemo(String name, Counter counter){
       super(name);
       this.counter = counter;
    }
   
   public void run() {
     synchronized(counter) {
        counter.printCount();
     }
     System.out.println("Thread " +  this.getName() + " exiting.");
   }

   @Override
   public void start (){
       super.start();
       System.out.println("Starting " +  this.getName());
   }
}

