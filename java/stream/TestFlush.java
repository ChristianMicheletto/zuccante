import java.io.*;
 
 
public class TestFlush {
 
    static float[] prices = { 2.50f, 1.00f, 1.50f };
    static String[] drinks = { "spritz","sucoo di frutta","aranciata"};
    
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("listino.txt")));
        for (int i = 0; i < prices.length; i ++) {
           out.writeFloat(prices[i]);
           out.writeUTF(drinks[i]);
        }
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("listino.txt")));
        float price;
        String drink;
        try {
            //boolean eof = false;
            while (in.available() != 0) {
                //if (!in.ready()) break;
                       price = in.readFloat();
                       drink = in.readUTF();
                       System.out.format("\t\t\t%f\r%s\n",price, drink);
                       
                       //if (in == -1)
                            //eof = true;
 
           }
        } catch (EOFException e) {
            e.printStackTrace();
        }
 
    }
}
