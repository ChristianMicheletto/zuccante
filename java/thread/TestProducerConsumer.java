import java.util.Date;
import java.util.concurrent.Semaphore;
 
public class TestProducerConsumer {
    public static void main(String args[]) {
        //instantiate (create) buffer shared by Producer & Consumer
        BoundedBuffer sharedBuffer = new BoundedBuffer();
        // create the producer and consumer threads
        Thread producerThread = new Thread(new Producer(sharedBuffer));
        Thread consumerThread = new Thread(new Consumer(sharedBuffer));
        		
        producerThread.start();
        consumerThread.start();               
    }
}

class BoundedBuffer { 
    
    private static final int BUFFER_SIZE = 4; 
    // private int count; // <= BUFFER_SIZE 
    private int in;  // head
    private int out;  // tail
    private Object[] buffer; // circular buffer
    // provides limited access to the buffer:
    // mutual exclusion: for producer and consumer (critical section)
    private Semaphore mutex; 
    // keep track of the number of empty elements in the array
    private Semaphore empty;
    // keep track of the number of filled elements in the array 
    private Semaphore full; 
       
    public BoundedBuffer(){
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
        mutex = new Semaphore(1); // 1 for mutual exclusion
        empty = new Semaphore(BUFFER_SIZE); // array begins with all empty elements
        full = new Semaphore(0); // array begins with no elements
    }
   
    public void insert(Object item) {
        try {
            mutex.acquire(); 
            empty.acquire(); 
            buffer[in] = item;
            in = (in + 1) % BUFFER_SIZE;
        } catch (InterruptedException e) { 
            e.printStackTrace();
        } finally {
            full.release(); // now the consumer can consume
            mutex.release(); 
        }
    }
   
    public Object remove() {
        Object item = null;
        try {
            mutex.acquire(); 
            full.acquire(); 
            item = buffer[out];
            out = (out + 1) % BUFFER_SIZE;
        } catch (InterruptedException e) { 
            e.printStackTrace();
        } finally {
            empty.release(); // take an element
            mutex.release(); 
        }
        return item;
    }   
}

class Producer implements Runnable {
    private  BoundedBuffer buffer;
    public Producer(BoundedBuffer b) {
        buffer = b;
    }
    public void run(){
        // DO SOMETHING
    }
}

class Consumer implements Runnable {
    private  BoundedBuffer buffer;
    public Consumer(BoundedBuffer b) {
        buffer = b;
    }
    public void run(){
        // DO SOMETHING
    }
}
