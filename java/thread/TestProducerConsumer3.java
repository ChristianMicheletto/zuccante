import java.util.concurrent.Semaphore;

public class TestProducerConsumer3{
    
    public static void main(String[] args) {
 
        Semaphore semaphoreProducer = new Semaphore(1);
        Semaphore semaphoreConsumer = new Semaphore(0);
           
        Producer producer = new Producer(semaphoreProducer, semaphoreConsumer);
        Consumer consumer = new Consumer(semaphoreConsumer, semaphoreProducer);
      
        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
 
        producerThread.start();
        consumerThread.start();
 
    }
}
 
 
 
 
/**
 * Producer Class.
 */
class Producer implements Runnable {
    
    final static int TIMES = 5;
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;
    
    
    public Producer(Semaphore semaphoreProducer,Semaphore semaphoreConsumer) {
           this.semaphoreProducer = semaphoreProducer;
           this.semaphoreConsumer = semaphoreConsumer;
    }
 
    public void run() {
        for(int i=1;i<=TIMES;i++){
            try {
                semaphoreProducer.acquire();
                // DO SOMETHING
                semaphoreConsumer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
/**
 * Consumer Class.
 */
class Consumer implements Runnable{
 
    final static int TIMES = 5;
    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;
    
    public Consumer(Semaphore semaphoreConsumer,Semaphore semaphoreProducer) {
           this.semaphoreConsumer = semaphoreConsumer;
           this.semaphoreProducer = semaphoreProducer;
    }
 
    public void run() {
        for(int i=1;i<=TIMES;i++){
            try {
                semaphoreConsumer.acquire();
                // DO SOMETHING
                semaphoreProducer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
