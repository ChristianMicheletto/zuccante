import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {
        ReadCSV reader = new ReadCSV();
        readers.run();
    }
    
    public void run() {
        
        String csvFile = "example.csv"; // scrivilo com libreoffice o esporta da una tabella MySQl
        BufferedReader br = null
        String line = "";
        String cvsSplitBy = ",";
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
			    String[] data = line.split(cvsSplitBy);
			    System.out.println("[data_4 = " + country[5] 
                                 + ", data_5 = " + country[6] + "]");
		    }
        } catch (FileNotFoundException e) {
		    e.printStackTrace();
	    } catch (IOException e) {
		    e.printStackTrace();
	    } finally {
		    if (br != null) {
			    try {
				    br.close();
			    } catch (IOException e) {
				    e.printStackTrace();
			    }
		    }
	    }
	    System.out.println("Done");
    }
}
