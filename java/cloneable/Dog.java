public class Dog extends Animal {
 
	public Dog(String name) {
		super(name);
	}
 
	public String bark() {
		return "Bow Bow!!";
	}
 
	public Dog clone() {
		return (Dog) super.clone();
	}
 
}
