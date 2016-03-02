import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeEvent;

public class Es001 {
    public static void main(String[] args) {
        
        final Employee e1 = new Employee("John Jacobs", 2000.0);
        
        // Compute the tax
        computeTax(e1.getSalary());
        
        // Add a property change listener to e1
        e1.addPropertyChangeListener(Es001::handlePropertyChange);
        
        // Change the salary
        e1.setSalary(3000.00);
        e1.setSalary(3000.00); // No change notification is sent.
        e1.setSalary(6000.00);
    }
    
    public static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("salary".equals(propertyName)) {
            System.out.print("Salary has changed. ");
            System.out.print("Old:" + e.getOldValue());
            System.out.println(", New:" + e.getNewValue());
            computeTax((Double)e.getNewValue());
        }
    }
    
    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT/100.0;
        System.out.println("Salary:" + salary + ", Tax:" + tax);
    }
}


class Employee {
    private String name;
    private double salary;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public Employee() {
        this.name = "John Doe";
        this.salary = 1000.0;
    }
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double newSalary) {
        double oldSalary = this.salary;
        this.salary = newSalary;
        // Notify the registered listeners about the change
        pcs.firePropertyChange("salary", oldSalary, newSalary);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
    
    @Override
    public String toString() {
        return "name = " + name + ", salary = " + salary;
    }
}
