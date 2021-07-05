import java.time.LocalDate;
import java.util.Scanner;

/*
 *  0000-00-00
 *  Sun Mon Tue Wed Thu Fri Sat
 *  ============================
 *			01	02  03  04  05
 * 	06	07	08	09	10	11	12
 * 	13	14	15	16	17	18	19
 * 	20	21	22	23	24	25	26
 * 	27	28	29	30
 * 
 */


public class Calendar {
	public static void main(String[] args) {
		
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDate someday = LocalDate.of(2021, 6, 24);
		System.out.println(someday);
		
		Scanner in = new Scanner(System.in);
		
		int y = in.nextInt();
		int m = in.nextInt();

		LocalDate wishday = LocalDate.of(y, m, 1);
		System.out.println(wishday);
						 //   7   1   2	  3	  4	  5   6  
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("============================= ");
									// 30 || 31 || 29
		for (int i = 1; i <= wishday.lengthOfMonth(); i++) { 
			wishday = LocalDate.of(y, m, i);
			int val = wishday.getDayOfWeek().getValue();
							//   7   1   2	  3	  4	  5   6  	
			if ( val != 7 && i == 1 ) {
			for (int j = 1; j <= val; j++) {
					System.out.print("    ");
				}
			}
			System.out.printf( "  %02d", i);
			if ( val == 6)
				System.out.print("\n");
		}

	}

}
