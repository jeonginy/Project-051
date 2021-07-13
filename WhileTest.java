import java.util.Scanner;
public class WhileTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int A = in.nextInt();
		int num = A / 10; // for the quotient
		int num2 = A % 10; // for the remainder
		int count = 1;		//	for counting how many steps need to get back to A's value
		
		while (true) {		// As an example : 26 -> B : 2   C : 6		- 	 count : 1
												//		 6	 	 8		- 	 count : 2
												//		 8		 4		- 	 count : 3
												//		 4		 2		- 	 count : 4
												//		 2 		 6		- 	 count : 5
			int sum = num + num2;		//	sum = 2 + 6 = 8	/ 6 + 8 = 14 / 8 + 4 = 12 / 4 + 2 = 6
			if( sum >= 10 ) {		//	-----  for an exception where A < 10  -----  
				sum = sum - 10;		//	14 - 10 = 4 / 12 - 10 = 2
			}
			num = num2;				//	B = 6	/	8	/	4	/	2
			num2 = sum;				//	C = 8	/	4	/	2	/	6
										//	-----  to make double figures -----
			int result = num*10 + num2;		//	result = 6*10  +  8 -> 68 / 8*10 + 4 -> 84 / 4*10 + 2 -> 42 / 2*10 + 6 -> 26 
			if( result == A )
			break;						//	exit
			count++; // count = 2 / 3 / 4
		}
		System.out.println(count);
	}

}
