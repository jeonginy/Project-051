package inter;

public interface Greeting {
	
	void greeting();
	
}

//	인터페이스를 하나 더 생성; 인터페이스를 상속하고 있는 새로운 인터페이스(인사도 할 수 있고, 글도 적을 수 있음) 
interface SpeakAndWrite extends Greeting {
	
	void write();
	
}