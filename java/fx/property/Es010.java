import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ReadOnlyProperty;

public class Es010 {
    public static void main(String[] args) {
    
        Book book = new Book("Il Nome della Rosa", 9.99, "0123456789");
    
        System.out.println("a book is created ...");
    
        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
    
        // Change the book's properties
        book.setTitle("Il Nome della Rosa (II ed.)");
        book.setPrice(9.49);
    
        System.out.println("... changed book properties ...");
    
        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
    }
 
    public static void printDetails(ReadOnlyProperty<?> p) {
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null)? "null":bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();
 
        System.out.print(propClassName);
        System.out.print("[Name:" + name);
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
}
 
class Book {
    private StringProperty title = new SimpleStringProperty(this, "title", "Unknown");
    private DoubleProperty price = new SimpleDoubleProperty(this, "price", 0.0);
    private ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this, "ISBN", "Unknown");
    
    public Book() {}
    
    public Book(String title, double price, String ISBN) {
        this.title.set(title);
        this.price.set(price);
        this.ISBN.set(ISBN);
    }
    
    public final String getTitle() {
        return title.get();
    }
    
    public final void setTitle(String title) {
        this.title.set(title);
    }
    
    public final StringProperty titleProperty() {
        return title;
    }
    
    public final double getprice() {
        return price.get();
    }
    
    public final void setPrice(double price) {
        this.price.set(price);
    }
    
    public final DoubleProperty priceProperty() {
        return price;
    }
    
    public final String getISBN() {
        return ISBN.get();
    }
    
    public final ReadOnlyStringProperty ISBNProperty() {
        return ISBN.getReadOnlyProperty();
    }
}
