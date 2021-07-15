//추상클래스 : 미완성 클래스
abstract class Player {
	boolean pause; // 일시정지 상태를 저장하기 위한 변수 ( false - 정지 / true - 실행 )
	int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

	Player() {
		pause = false;
		currentPos = 0;

	}

	abstract void play(int pos); // abstract를 사용함으로써, 비어있는 기능이 있음을 알려줌 - 추상메서드 : 미완성 메서드

	// 재생을 즉시 멈추는 기능을 수행하도록 작성
	abstract void stop();

	void play() {
		play(currentPos); // 추상메서드 사용 가능
	}
}

//추상 클래스는 상속을 통해 완성해야 객체 생성 가능 
class AudioPlayer extends Player {
	// 완성된 메서드
	void play(int pos) {
		System.out.println(pos + "위치부터 play합니다.");
	}

	void stop() {
		System.out.println("재생을 멈춥니다.");
	}

}

abstract class AbstractPlayer extends Player {
	void play(int pos) {

	}
}

public class AbsractTest {
	public static void main(String[] args) {

//		Player p = new Player();
//		AudioPlayer ap = new AudioPlayer();		
		Player ap = new AudioPlayer();		//	다형성에 의해서 생성 후 메서드 이용 가능 		
		
		ap.play(100);
		ap.stop();
	}
}