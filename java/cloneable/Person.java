public class Person implements Cloneable{
 
	private String name;
 
	public Person(String name) {
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public Person clone() {
		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
