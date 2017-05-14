public class Lambda {
    
    // define the object sine
    DoubleFunction sine = (double x) -> Math.sin(x);
    double result1 = Simpson.integrate(sine, 0, Math.PI, 30);
    // an alternative
    double result2 = Simpson.integrate(x -> Math.sin(x), 0, Math.PI, 30);
    // with method reference
    double result3 = Simpson.integrate(Math::sin, 0, Math.PI, 30);
    
    public static void main(String[] args){
        Lambda l = new Lambda();
        
        System.out.println("result1: " + l.result1);
        System.out.println("result2: " + l.result1);
        System.out.println("result3: " + l.result1);
        
        
    
    }

}
