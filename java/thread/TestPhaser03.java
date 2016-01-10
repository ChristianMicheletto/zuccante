import java.util.concurrent.Phaser;


public class TestPhaser03 {
    public static void main(String[] args) {
        // Creates a new phaser with no initially registered parties, no parent, and initial phase number 0.
        Phaser phaser = new Phaser() {
            
            @Override
            protected boolean onAdvance(int phase, int parties) {
                System.out.println("Inside onAdvance(): phase  = " + phase
                   + ",  Registered Parties = " + parties);
                // return true: terminates the phaser
                return false;
            }
        };
        // Register the self (the "main" thread) as a party 
        phaser.register();
        System.out.println("#1: isTerminated():" + phaser.isTerminated());
        phaser.arriveAndDeregister();

        // Trigger another phase advance
        phaser.register();
        phaser.arriveAndDeregister();

        System.out.println("#2: isTerminated():" + phaser.isTerminated());
        phaser.forceTermination();
        System.out.println("#3: isTerminated():" + phaser.isTerminated());
    }
}
