public enum Month {
	// 최상위 Object에는 toString이 있는것처럼 enum역시 자동적으로 toString함 
	JAN(1, "1월"),
	FEB(2, "2월"),
	MAR(3, "3월"),
	APR(4, "4월"),
	MAY(5, "5월");
	//	클래스와 같이 필드와 생성자 getter&setter, toString 다 사용 가능 
	private int value;
	private String kor;
	// Month 필드에게 숫자값을 주기 위해 int형 변수를 만들어 놔야함 -1, 생성자도 만들어 놔야함 -2
	Month(int value, String kor){
		this.value = value;
		this.kor = kor;
	}
	// 생성자에 맞게 각 달의 변수 뒤에 int형 값을 넣어줌 -3
	// getter 생성 -4
	public int getValue() {
		return value;
	}
	// ToString이 자동으로 돼있음
	@Override
	public String toString() {
		return super.toString() + ": " + value + " " + kor + "입니다.";
	}
	
}
