import java.util.List;

 public class Main {

 	public static void main(String[] args) {		
		Rabbit r = new Rabbit();
		r.setName("Lay");	//	r.setName != ("Lay");
		r.setAge(10);		//	r.setAge != (10);

 //		System.out.println(r.getName());
//		System.out.println(r.getAge());

 		Rabbit r2 = new Rabbit("Holy", 3);

 		System.out.println(r.toString());
		System.out.println(r2.toString());

 		System.out.println(r.equals(r2));

 		CarrotFactory factory = new CarrotFactory();
		List<Carrots> List = factory.makingCarrots(5);

 //		to feed a rabbit with carrots
		r.eat(new Carrots(0));
		System.out.println(r.isHungry());

 		Carrots c = new Carrots(11);
		r.eat(c);
		System.out.println(r.isHungry());
		System.out.println(c.getWeight());


 	}

 } 
