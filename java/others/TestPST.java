import java.io.IOException;

public class TestPST {
    public static void main(String[] args){
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
