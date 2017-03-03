import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

// waiting multiple concurrent events

public class TestVideoconference {
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
    
        Thread threadConference = new Thread(conference);
        threadConference.start();
    
        for (int i=0; i<10; i++){
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

class Videoconference implements Runnable{
    private final CountDownLatch controller;
    
    public Videoconference(int number) {
        controller = new CountDownLatch(number);
    }
    
    public void arrive(String name){
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",
        controller.getCount());
    }
        
    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n",
        controller.getCount());
        /*
         * public boolean await()
         *                throws InterruptedException
         * 
         * Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.
         */
        try {
            controller.await(); 
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Participant implements Runnable {
    
    static final Random random = new Random((new Date()).getTime());
    
    private Videoconference conference;
    private String name;
    
    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }
    
    @Override
    public void run() {
        int duration = 1 + random.nextInt(9);
        try {
          TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
        System.out.printf("### %s, OK ###\n", Thread.currentThread().getName());
    }
}
       
         
