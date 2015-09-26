public class CloneableTest {
 
	public static void main(String[] args) {
        System.out.println("*** test I ***");
		Person p = new Person("Sam");
		Person pClone = p.clone(); // Can you do this, if clone method in Person class is not public
		System.out.println(pClone.getName());
        
        System.out.println("*** test II ***");
        Animal a = new Animal("Chimera");
        Animal aClone = a.clone();
        System.out.println(aClone.getName());
        
        System.out.println("*** test III ***");
        Dog dog = new Dog("Puppy");
		Dog dogClone = dog.clone(); //Do you think, you can do this?
		System.out.println(dogClone.getName());
	}
}
