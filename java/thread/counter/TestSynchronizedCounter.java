public class TestSynchronizedCounter {
    
    // un'unica risorsa cui accederanno i 2 thread
    static final SynchronizedCounter c = new Counter();

    public static void main(String[] args) {
        
        // first thread
        new Thread(new Runnable() {
            public void run() { 
                System.out.println(c.getValue()); 
                c.increment();
                try {
                    // thread to sleep for 1 milliseconds
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                c.decrement();
            }
        }).start();
        
        // second thread
        new Thread(new Runnable() {
            public void run() { 
                System.out.println(c.getValue()); 
                c.increment();
                System.out.println(c.getValue()); 
            }
        }).start();
    }
}
