public class TestDog {

	public static void main(String[] args) {
		Dog myDog = new Dog();
	
		myDog.name = "Berry";
		myDog.kinds = "Golden Retriever";
		myDog.age = 3;

		myDog.print();
		myDog.bark("Bow Wow");
		myDog.bite("Pffffffffff");
		myDog.eat("Chw Chw");
		
	}
}


class Dog{
	String name;
	String kinds;
	int		age;
	
	void bark(String barking) {				// void bark(){	System.out.println("Bow Wow");} 	
		System.out.println(barking);
		}
	
	void bite(String biting) {
		System.out.println(biting);
	}
	
	void eat(String eating){
		System.out.println(eating);
	}
	void print()
	{
		System.out.println("(" + name + "," + kinds + "," + age + ")");
		
	}
	
}