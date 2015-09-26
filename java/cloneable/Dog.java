public class Dog extends Animal implements Cloneable{
 
	public Dog(String name) {
		super(name);
	}
 
	public String bark() {
		return "Bow Bow!!";
	}
    
}
