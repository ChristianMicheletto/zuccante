import java.io.*;

public class SerializeDemo {
    public static void main(String [] args) {
        Employee e = new Employee("Alì Babà", "Caverna dei 40 ladroni", 66666666, 123);
      
        try {
            FileOutputStream fileOut =
            new FileOutputStream("./tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            // open file with ghex 
            System.out.printf("Serialized data is saved in ./tmp/employee.ser");
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
