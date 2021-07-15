package inter2;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Date today = new Date( 2021, 6, 23, Days.WEDNESDAY);	//	2021-06-23
		Date restDay = new Date( 2021, 6, 26, Days.SATURDAY); 	//	2020-06-01
		
		
		LocalDate now =  LocalDate.now();	//	new 라는 생성자 없이 static하게 만들 수 있음 
		LocalDate someDay =  LocalDate.of(2020, 6, 1);	// 원하는 날짜를 생성(private생성자를 가지고 있기 때문에, 설정할 때 잘 봐두기) 
		LocalDate passingDay = LocalDate.parse("2021-01-02");		// ""값을 보내줌
		LocalDate tomorrow = now.plusDays(1);
		
		System.out.println(passingDay);
		
		System.out.println("일 :" + now.getDayOfMonth());	//	일
		System.out.println("월 :" + now.getMonth());	//	월
		System.out.println("월 value :" + now.getMonth().getValue());	//	월 객체의 값
		System.out.println("년 :" + now.getYear());		//	년	
		System.out.println("요일 :" + now.getDayOfWeek());		//	요일 객체 	
		System.out.println("요일 value :" + now.getDayOfWeek().getValue());	//	요일 객체의 값
		System.out.println("달 길이 :" + now.lengthOfMonth());		//	달의 길이 값 
		
		switch( restDay.dayOfWeek) {
		case 1: case 2: case 3: case 4: case 5:
			System.out.println("Working");
			break;
		case Days.SATURDAY:
		case Days.SUNDAY:
			System.out.println("Holiday");
			break;
			
		}
		
		
//		System.out.println(now);
//		System.out.println(someDay);
//		System.out.println(parsing);
//		System.out.println(tomorrow);
//		
	}
}
