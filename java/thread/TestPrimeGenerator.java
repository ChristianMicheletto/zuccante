public class TestPrimeGenerator {
    public static void main(String[] args) {
        Thread task=new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
