import java.util.Date;
import java.text.SimpleDateFormat;

public class TestClone implements Cloneable {
 
	private String s;
    private int n;
	private Date d;
 
	public TestClone(String s, int n, Date d) {
		this.s = s;
		this.n = n;
        this.d = d;
	}
 
	public TestClone clone() {
		TestClone t;
		try {
			t = (TestClone) super.clone();
			t.d = (Date) d.clone();
			return t;
		} catch (CloneNotSupportedException e) {
                        e.printStackTrace();
			throw new RuntimeException();
		}
	}
    
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date = new Date();
	    String sdate = sdf.format(date);
        TestClone test = new TestClone("test", 1,  date);
        System.out.println(sdate);
    }
}
