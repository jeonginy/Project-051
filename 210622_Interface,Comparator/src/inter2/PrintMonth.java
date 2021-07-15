package inter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/*
 * 이번달 달력 출력
 * 
 * 일 월 화 수 목 금 토
 * --------------------
 *       01 02 03 04 05
 * 06 07 08 09 10 11 12
 * 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26
 * 27 28 29	30
 */

public class PrintMonth {

	public static void main(String[] args) throws IOException {
//		System.out.println(" 7  1  2  3  4  5  6");
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		
//		System.out.println("      01 02 03 04 05\n" + 
//						   "06 07 08 09 10 11 12\n" + 
//						   "13 14 15 16 17 18 19\n" + 
//						   "20 21 22 23 24 25 26\n" + 
//						   "27 28 29 30");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		System.out.println("원하는 날짜를 입력해 주세요.(2021-03-01)");
		String someDay = br.readLine();
		calender( LocalDate.parse( someDay ) );
		
		br.close(); // 닫기
	}
	

	private static void calender(LocalDate someDay) {
		someDay = LocalDate.of(someDay.getYear(), someDay.getMonth(), 1); // 년도 월만 가져오고 날짜는 1일으로 초기화
		int length = someDay.lengthOfMonth(); // 달의 마지막 일 ex) 2021-06-01 => 30
		int weekValue = someDay.getDayOfWeek().getValue(); // 요일 값 : 월(1) ~ 일(7)
		
		System.out.println( "\n" + someDay.getYear() + "년 " + someDay.getMonth().getValue() + "월" ); // 2021년 6월
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		
		// 첫번째 1일이 어디서 시작되는지 알아야함
		if(weekValue != 7) { // 일요일이면 안 띄워도 됨.
			for(int i = 1; i <= weekValue; i++) {
				System.out.print("   "); // 공백 띄움
			}			
		}
		
		for(int i = 1; i <= length; i++) {
			System.out.printf("%02d ", i);
			
			// 토요일이면 줄 띄우기
			if( someDay.getDayOfWeek().getValue() == 6 ) {
				System.out.println();
			}
			

			//someDay = LocalDate.of(someDay.getYear(), someDay.getMonth(), i);
			someDay = someDay.plusDays(1); // i 값 증가시 마다 날짜++;
		}
	}
}