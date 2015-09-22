import java.util.Scanner; // By default, a scanner uses white space to separate tokens. 

public class TestScannerInt {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        System.out.println("Ho inserito: " + n1); // cast
        int n2 = sc.nextInt();
        System.out.println("Ho inserito: " + n2); // cast
        System.out.println("La loro somma è: " + (n1+n2)); // trick
    }
}
