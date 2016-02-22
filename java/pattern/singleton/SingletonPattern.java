// Singleton

final class Singleton {
    private static Singleton s = new Singleton(666);
    private int i;
    
    //NB: provate constructor
    private Singleton(int x) { i = x; }
    
    public static Singleton getReference() {
        return s;
    }
    
    public int getValue() { return i; }
    
    public void setValue(int x) { i = x; }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getReference();
        System.out.println(s1.getValue());
        Singleton s2 = Singleton.getReference();
        s2.setValue(3);
        System.out.println(s1.getValue());
        try {
            // Can't do this: compile-time error.
            // Singleton s3 = (Singleton)s2.clone();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
