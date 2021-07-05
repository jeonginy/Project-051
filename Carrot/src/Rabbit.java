
public class Rabbit extends Object {
//	field, member value
	private String name;
	private int age;
//	staus - hungry
	private boolean hungry; // true = hungry, false = full

	public Rabbit() {
//		public constructor
		this.hungry = hungry;
	}

	public Rabbit(String name, int age) {
		super(); // automatically build
		this.name = name;
		this.age = age;
		this.hungry = true;
		
	}
//	method : A rabbit is hungry, be able to eat carrots and full

	public boolean isHungry() {
		return hungry;
	}
	
	public void eat(Carrot c) {
		if ( c != null && c.getWeight() > 10 ) {	//	when it gets 10gram, a rabbit can eat 
			c.setWeight( c.getWeight() - 10 );		//	original carrot weight -10 
			this.hungry  = false;					//	a rabbit is full
			
		}
	}

	public void setHungry(boolean isHungry) {
		this.hungry = isHungry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) { // Object class is Parent class
		if (!(o instanceof Rabbit)) { // to check whether casting is available - true, or not - false 
			return false; // exit if
		}
		Rabbit other = (Rabbit) o; 
		return name.equals(other.name) && age == other.age; 
	}

	@Override
	public String toString() {
		return "Rabbit [name=" + name + ", age=" + age + "]";
	
	
	
	
	}

}
