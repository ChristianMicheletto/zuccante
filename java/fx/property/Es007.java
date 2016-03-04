import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Es007 {
    public static void main(String[] args){
        User user1 = new User();
        System.out.println("user1 has name: " + user1.getUserName());
        System.out.println("user1 has name: " + user1.userNameProperty().get());
        System.out.println("user1 has password: " + user1.getPassword());
        user1.setPassword("blablabla");
        System.out.println("user1 has password: " + user1.getPassword());
    }
}

/*****************************************************************************************
 * 
 * Creating a read-only property needs two steps.
 * instantiate a read-only wrapper class
 * invoke the method getReadOnlyProperty() to return a true read-only property object
 * 
 * ReadOnlyStringWrapper userName = new ReadOnlyStringWrapper("java2s.com"); 
 * ReadOnlyStringProperty readOnlyUserName  = userName.getReadOnlyProperty();
 * 
 * *****************************************************************************************
 * 
 * java.lang.Object
 *   javafx.beans.binding.StringExpression
 *     javafx.beans.property.ReadOnlyStringProperty
 *       javafx.beans.property.StringProperty
 *         javafx.beans.property.StringPropertyBase
 *           javafx.beans.property.SimpleStringProperty
 *             javafx.beans.property.ReadOnlyStringWrapper
 * 
 ********************************************************************************************/


class User {
    private final static String USERNAME_PROP_NAME = "userName";
    private final ReadOnlyStringWrapper userName;
    private final static String PASSWORD_PROP_NAME = "password";
    private StringProperty password;

    public User() {
        userName = new ReadOnlyStringWrapper(this, USERNAME_PROP_NAME,"fake user");
        password = new SimpleStringProperty(this, PASSWORD_PROP_NAME, "password");
    }
    
    public final String getUserName() {
        return userName.get();
    }

    public ReadOnlyStringProperty userNameProperty() {
        return userName.getReadOnlyProperty();
    }

    public final String getPassword() {
        return password.get();
    }

    public final void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
