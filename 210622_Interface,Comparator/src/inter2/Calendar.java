package inter2;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
	
	/*
	 *이번 달 달력 출력
	 * 
	 * 일 월 화 수 목 금 토  : sys();
	 * --------------------- : sys();
	 * 		 01 02 03 04 05	 : 공백 2개 필요
	 * 06 ..... 30			 : LocalDate 생성
	 */

	public static void main(String[] args) {
//		LocalDate now = LocalDate.now();	//현재 날짜
//		LocalDate J = LocalDate.of(2021, 06, 01);	//특정 날짜 정하기
			
//		System.out.println(now);
//		 now.getDayOfWeek().getValue()
		
		Scanner in = new Scanner(System.in);
		int y = in.nextInt();
		int m = in.nextInt();
		
		LocalDate n = LocalDate.of(y, m, 1);

		System.out.println(" Sun Mon Tue  Wed Thu Fri Sat ");
		System.out.println("------------------------------");
//		System.out.print("              01     02    03    04    05\n" );
		
		for( int i = 1; i <= n.lengthOfMonth() ; i++ ) {
			LocalDate s = LocalDate.of(y, m, i);		// i 요일을 뽑아내려고?
			int sv = s.getDayOfWeek().getValue();
			
			if( i == 1 && sv != 7 ) {			//	일요일이 아닐 때
				for(int j = 0; j < sv; j++ ) {
					System.out.print("    ");
				}
			}
			System.out.printf("  %02d", i );
			if( sv == 6 ) {
				System.out.print("\n");
			}
		}
		
		
		
	}

} 
