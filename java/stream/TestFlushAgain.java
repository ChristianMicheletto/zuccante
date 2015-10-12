import java.io.*;
 
 
public class TestFlushAgain {
 
    static float[] prices = { 30.00f, 11.00f, 45.00f};
    static String[] books = { "Lern JAVA","PHP Tutorial","Mysql How To"};
    public static void main(String[] args) throws IOException {
        
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")));
        for (int i = 0; i < prices.length; i ++) {
            out.writeFloat(prices[i]);
            out.writeUTF(books[i]);
            // try to comment the the next line and read books.dat
            out.flush();
        }
        
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("books.dat")));
        float price;
        String book;
 
        try {
            //boolean eof = false;
            while (in.available() != 0) {
                //if (!in.ready()) break;
                price = in.readFloat();
                book = in.readUTF();
                System.out.printf("\t\t\t %.2f  \r%s \n", price, book);
                //if (in == -1) eof = true;
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
    }
}
