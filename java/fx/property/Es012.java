import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
 
// from Learn java FX8, modified by AM

public class Es012 {
    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);
        
        // Add a change listener to the counter property
        counter.addListener((prop, oldValue, newValue) -> 
            {
                System.out.print("Counter changed: ");
                System.out.println("oldValue = " + oldValue + ", newValue = " + newValue);
            }
        );
        
        System.out.println("\nBefore changing the counter value-1");
        counter.set(101);
        System.out.println("After changing the counter value-1");
        
        System.out.println("\nBefore changing the counter value-2");
        counter.set(102);
        System.out.println("After changing the counter value-2");
        
        // Try to set the same value
        System.out.println("\nBefore changing the counter value-3");
        counter.set(102); // No change event is fired.
        System.out.println("After changing the counter value-3");
        
        // Try to set a different value
        System.out.println("\nBefore changing the counter value-4");
        counter.set(103);
        System.out.println("After changing the counter value-4");
    }
    
    /*
     * public static void changed(ObservableValue<? extends Number> prop,
     *   Number oldValue, Number newValue) {
     *     System.out.print("Counter changed: ");
     *     System.out.println("Old = " + oldValue + ", new = " + newValue);
     * }
     */
}
