public class CloneableTest {
 
	public static void main(String[] args) {
        System.out.println("*** First test ***");
		Person p = new Person("Sam");
		Person pClone = p.clone(); // Can you do this, if clone method in Person class is not public
		System.out.println(pClone.getName());
        System.out.println("*** Second test ***");
        Dog dog = new Dog("Puppy");
		Dog dogClone = dog.clone(); //Do you think, you can do this?
		System.out.println(dogClone.getName());
	}
}
