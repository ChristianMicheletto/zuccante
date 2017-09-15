public class HelloRunnable2 {

    public static void main(String args[]) {
        new Thread(()->System.out.println("Hello from a thread, in labda form!")).start();
    }

}
