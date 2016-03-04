import javafx.beans.property.*;

public class Es009 {
    public static void main(String[] args){
        // *** int
        // IntegerProperty is abstract
        int val1 = 1;
        IntegerProperty counter = new SimpleIntegerProperty(val1);
        System.out.println("counter.set("+ val1 + ")");
        int counterValue = counter.get();
        System.out.println("counter.get() return " + counterValue);
    
        int val2 = 2;
        counter.set(val2);
        System.out.println("counter.set("+ val2 + ")");
        counterValue = counter.get();
        System.out.println("counter.get() return " + counterValue);
        
        // *** String
        
        StringProperty password  = new SimpleStringProperty("parabynzibunziba2015");
        System.out.println("Old StringProperty "  + password.get() );
        password.set("vivalacioccolata2016");
        System.out.println("Modified StringProperty "  + password.get() );
        
        // *** Double
        
        DoubleProperty schei = new SimpleDoubleProperty(1200.00);
        System.out.println("schei.get() return " + schei.get());
        
        // read only
        ReadOnlyIntegerWrapper idWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty id = idWrapper.getReadOnlyProperty();

        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.get());
        // id.set(200); *** cannot find symbol
 
        // Change the value
        idWrapper.set(101);
 
        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.get());
    }
}

