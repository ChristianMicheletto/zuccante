import java.util.Arrays;

// splitting

public class RegExp002 {
    public static String knights =
      "Then, when you have found the shrubbery, you must " +
      "cut down the mightiest tree in the forest... " +
      "with... a herring!";
      
    public static void main(String[] args) {
        // split return String[]
            
        String[] ret;
        ret = knights.split(" "); // Doesn’t have to contain regex chars
        System.out.println(Arrays.toString(ret));
        System.out.println("*********");
        ret = knights.split("\\W+"); // Non-word characters
        System.out.println(Arrays.toString(ret));
        System.out.println("*********");
        ret = knights.split("n\\W+"); // ‘n’ followed by non-word characters
        System.out.println(Arrays.toString(ret));
        System.out.println("*********");
    }
}
