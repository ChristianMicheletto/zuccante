// replacing

public class RegExp003 {
    
    static String s = RegExp002.knights;
    
    
    public static void main(String[] args) {
        
        System.out.println(s);
        System.out.println(s.replaceFirst("f\\w+", "located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
