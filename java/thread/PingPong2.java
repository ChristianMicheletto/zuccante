public class PingPong2 extends Thread {
    
    private String word;
    private int delay;
    int times;
    
    public PingPong2(String whatToSay, int delayTime, int t) {
        word = whatToSay;
        delay = delayTime;
        times = t;
        }
        
    public void run() {
        try {
            for (;;) {
                System.out.print(word + " " + times + " ");
                Thread.sleep(delay); // wait until next time
                times--;
                if (times == 0) return;
                }
        } catch (InterruptedException e) {
            return;
            // end this thread
        }
    }
    
    public static void main(String[] args) {
        new PingPong2("ping", 3000, 10).start(); // 3s
        new PingPong2("PONG", 1000, 10).start(); // 1s
        }
}
