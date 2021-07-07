package inter;
/* 
 * 한국어로 인사할 수 있는 한국인
 * 영어로 인사할 수 있는 미국인
 * 스페인어로 인사할 수 있는 인공지능 스피커
 */

class Korean implements Greeting {
	
	@Override
	public void greeting() {
		System.out.println("안녕하세요.");
	}
	
}
class Ai implements Greeting {
	
	@Override
	public void greeting() {
		System.out.println("Chao");		
	}
	
	
}

public class American implements Greeting, Kissing {

	@Override
	public void greeting() {
		System.out.println("Hello");
	}
	
	@Override
	public void kissing() {
		System.out.println("쪽");
	}
	
//	1) abstract method일 경우 - 인터페이스 명.super.method();를 불러옴
//	2) default method로 해놨을 경우 - 해당 클래스에서 호출없이 바로 main() 에서 호출 가능 
	
	public static void main(String[] args) {
		Greeting k = new Korean();
		American a = new American();
		Greeting ai = new Ai();
		
		k.greeting();
		a.greeting();
		a.kissing();
		
		ai.greeting();
		
	}

}






