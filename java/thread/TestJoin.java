public class TestJoin {
  
    public static void main(String args[]) throws InterruptedException {
      
        System.out.println(Thread.currentThread().getName() + " is Started");
      
        Thread exampleThread0 = new Thread(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        
        Thread exampleThread1 = new Thread(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                     ex.printStackTrace();
                }
            }
        };
        
        exampleThread0.start();      
        exampleThread1.start();
        System.out.println("START");
        exampleThread0.join();
        exampleThread1.join();
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
    }
  
}
