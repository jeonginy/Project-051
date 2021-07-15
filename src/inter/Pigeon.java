package inter;
class Plane implements Flyable {
	
	@Override
	public void fly() {
		System.out.println("비행기가 슈웅 납니다.");
		
	}
}

public class Pigeon implements Flyable, MyInterface {

	@Override
	public void myMethod() {
		MyInterface.super.myMethod();
		System.out.println("override accepted");
	}

	@Override
	public void fly() {
		System.out.println("비둘기가 파닥파닥 납니다.");
	}
	 
	public static void main(String[] agrs) {
		Pigeon pigeon = new Pigeon();
		Flyable plane = new Plane();
		
		pigeon.fly();
		pigeon.myMethod();
		
		plane.fly();
		
		
	}
	
}
