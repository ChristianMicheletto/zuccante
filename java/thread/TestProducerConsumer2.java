import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProducerConsumer2 {
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
    // keep track of the number of empty elements in the array
    private Semaphore empty;
    // keep track of the number of filled elements in the array 
    private Semaphore full; 
    Lock criticalSection; // lock for critical section
       
    public BoundedBuffer(){
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
        empty = new Semaphore(BUFFER_SIZE); // array begins with all empty elements
        full = new Semaphore(0); // array begins with no elements
        criticalSection = new ReentrantLock();
    }
   
    public void insert(Object item) {
        criticalSection.lock();
        try {
            empty.acquire(); 
            buffer[in] = item;
            in = (in + 1) % BUFFER_SIZE;
        } catch (InterruptedException e) { 
            e.printStackTrace();
        } finally {
            full.release(); // now the consumer can consume
            criticalSection.unlock();
        }
    }
   
    public Object remove() {
        Object item = null;
        criticalSection.lock();
        try {
            full.acquire(); 
            item = buffer[out];
            out = (out + 1) % BUFFER_SIZE;
        } catch (InterruptedException e) { 
            e.printStackTrace();
        } finally {
            empty.release(); // take an element
            criticalSection.unlock();
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
