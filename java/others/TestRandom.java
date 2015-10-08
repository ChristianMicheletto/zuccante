import java.util.Random;

public class TestRandom {
    
    public static void main(String[] args) {
        
        Random r; 
        long seed;
        
        System.out.println("sequenza I");
        seed = 10;
        r = new Random(seed);
        for(int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(60)+" ");
        }
        System.out.print("\n\n");
        
        System.out.println("sequenza II");
        seed = 10;
        r = new Random(seed);
        for(int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(60)+" ");
        }
        System.out.print("\n\n");
        
        System.out.println("sequenza III");
        seed = 33;
        r = new Random(seed);
        for(int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(60)+" ");
        }
        System.out.print("\n\n");
        
        System.out.println("sequenza III");
        r = new Random(System.currentTimeMillis());
        for(int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(60)+" ");
        }
    }
}
