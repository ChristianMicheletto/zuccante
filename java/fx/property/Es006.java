import javafx.beans.property.SimpleStringProperty;
// javafx.beans.property.SimpleBooleanProperty
// javafx.beans.property.SimpleintegerProperty
// System.out.println("Modified StringProperty "  + password.get() );
// javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.StringProperty;


public class Es006{
    public static void main(String[] args) {
        StringProperty password  = new SimpleStringProperty("babbuino@2015");
        System.out.println("password StringProperty "  + password.get() );
        password.set("macaco@2016");
        System.out.println("Modified passoword StringProperty "  + password.get() );
  }
}
