import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Phaser;

public class TestProducerConsumer4 {
    
    public static void main(String[] args) {
        
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        
        Exchanger<List<String>> exchanger = new Exchanger<>();
        
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);
        threadProducer.start();
        threadConsumer.start();
    }
}

class Producer implements Runnable {
    
    private List<String> buffer;
    // An Exchanger may be viewed as a bidirectional form of a SynchronousQueue. 
    // we can echange a data structure; here a buffer
    private final Exchanger<List<String>> exchanger;
    
    public Producer (List<String> buffer, Exchanger<List<String>> exchanger){
        this.buffer = buffer;
        this.exchanger = exchanger;
    }
    
    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++){
            System.out.printf("Producer: Cycle %d\n", cycle);
            // in each cycle, add 10 strings to the buffer.
            for (int j = 0; j < 10; j++){
                String message = "Event " + ((i*10)+j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }
            // call the exchange() method to interchange data with the consumer. As this method
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer: " + buffer.size());
            cycle++;
        }
    }
}

class Consumer implements Runnable {
    
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;
    
    public Consumer (List<String> buffer, Exchanger<List<String>> exchanger){
        this.buffer = buffer;
        this.exchanger = exchanger;
    }
    
    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++){
            System.out.printf("Consumer: Cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + buffer.size());
            for (int j = 0; j < 10; j++){
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }
}


