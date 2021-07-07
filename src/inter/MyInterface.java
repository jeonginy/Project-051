package inter;

public interface MyInterface {
	
//	static constants 를 가질 수 있음 ( 둘 다 가능)
//	public static final int MY_NUMBER = 22;			
	int MY_NUMBER = 22;			//	(절대 변하지 않음)
	
//	defualt method 사용 가능 : 추상 메서드를 사용할 시, 매번 바디 부분을 만들어야 함이 번거롭기 때문에 기본 값을 정의 해놓음 (상위 버전에서 사용 가능) 
//	override 를 할 경우, 기존의 디폴트 값을 변경할 수도 있음 
	default void myMethod() {
		System.out.println("Helloo");
	}
		
//	static 메서드는 추상 메서드이면 안됨, 만들어줘야 함 - Flyable에서 void fly(); 형태로 쓰지 못함
	public static void hi() {
		System.out.println("hi");
		
		
	}
	
}
