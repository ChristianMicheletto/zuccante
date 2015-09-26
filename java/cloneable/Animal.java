public class Animal implements Cloneable {
 
	private String name;
 
	public Animal(String name) {
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public String bark() {
		return "This is how i bark, better care not";
	}
 
    /**
	public Animal clone() {
		// violation of contract to call super.clone() when creating instance of
		// the right class
		return new Animal(name);
	}
    **/
    
    public Animal clone() {
		try {
			return (Animal) super.clone();
		} catch (CloneNotSupportedException e) {
                        e.printStackTrace();
			throw new RuntimeException();
		}
	}
 
}
