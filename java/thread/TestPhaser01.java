import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Phaser;

public class TestPhaser01 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        for (int i = 1; i <= 3; i++) {
            phaser.register();
            String taskName = "Task  #" + i;
            Thread t = new Thread(new StartTogetherTask(phaser), taskName);
            t.start();
        }
        phaser.arriveAndDeregister();
    }
}


class StartTogetherTask implements Runnable {
    private Phaser phaser;
    private static Random rand = new Random((new Date()).getTime());

    public StartTogetherTask(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s :Initializing...\n", Thread.currentThread().getName());
        int sleepTime = rand.nextInt(5) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s :Initialized...\n", Thread.currentThread().getName());
        // if registered ...
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s :Started...\n", Thread.currentThread().getName());
    }
}

