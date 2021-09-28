public class TestEnum {
	public static void main(String[] args) {

// =====================================================================   Month  ================		
		
		Month m = Month.JAN;		//	1월의 객체를 생성 
		Month m2 = Month.JAN;		//	enum을 여러번 만드는 것처럼 보이지만, 하나의 객체만 생성돼있는 것임
		System.out.println(m);
		System.out.println(m.getValue());
		
		System.out.println(m == m2);	// 그렇기 때문에 같은 객체임 
// =====================================================================  Season  ================
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
		System.out.println(Season.FALL);
		System.out.println(Season.WINTER);
		
		Season myfavSeason = Season.FALL;
		if(myfavSeason == Season.FALL) {
			System.out.println("가을을 좋아합니다.");
		}
		
		switch(myfavSeason) {
		case FALL:
		System.out.println("switch도 가을을 좋아합니다.");
		break;
		}
	}
}
