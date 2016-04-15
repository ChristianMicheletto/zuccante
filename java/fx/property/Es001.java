import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

// From Oracle Tutorial (modified by AM)

public class Es001 {
    public static void main(String[] args) {
        Bill electricBill = new Bill();
        electricBill.amountDueProperty().addListener(new ChangeListener(){
        
        @Override public void changed(ObservableValue o, Object oldVal, Object newVal){
             System.out.println("Electric bill has changed: from " + oldVal + " to " + newVal);
        }
    });
     
    electricBill.setAmountDue(100.00); /// BAAAM
     
    }
}
 
class Bill {
 
    // Define a variable to store the property
    private DoubleProperty amountDue = new SimpleDoubleProperty();
 
    // Define a getter for the property's value
    public final double getAmountDue(){return amountDue.get();}
 
    // Define a setter for the property's value
    public final void setAmountDue(double value){amountDue.set(value);}
 
     // Define a getter for the property itself
    public DoubleProperty amountDueProperty() {return amountDue;}
 
}
