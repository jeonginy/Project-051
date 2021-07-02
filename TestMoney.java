import java.util.Scanner;

public class TestMoney {

	public static void main(String[] args) {
		
		// int    []  prdNum   = { 1, 2, 3  };
		String []  products = {
			"Coffee", "Tea", "Kakao", "Smoothie"
		};
		int    []  prices   = { 
			2300,  1800,   2250,  3500  
		};   
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("List");
		System.out.println(
			"1.Coffee(2300)  2.Tea(1800) 3.Kakao(2250), 4.Smoothie");
		
		System.out.println("your choice(1,2,3,4):");		
		int  choice  =  in.nextInt();
		
		System.out.println("deposit:");
		int  money   =  in.nextInt();
				
		System.out.println(
			products[ choice - 1 ] + "(" 
		    + prices[ choice - 1 ] + ") is selected");
		 
		// change
		int  change  =  money - prices[ choice - 1 ];
		 System.out.println( "change: " + change );
		 
		 if( change < 0 ) {
			 System.out.println("입금액이 모자랍니다");
			 System.exit(01);// return -1;
		 }
		 
		 int []  curr = {10000,5000,1000,500,100,50,10,5,1};
		 int []  quotient   = {    0,   0,   0,  0,  0, 0, 0,0,0};
		 
		 int ch  = change; 
		 for (int i = 0; i < quotient .length; i++) {
			 quotient[ i ] = ch / curr[ i ];
			 ch       = ch % curr[ i ];
		 }
		 
		 for (int i = 0; i < quotient.length; i++) {
			System.out.printf("%7d  %4d\n", curr[i], quotient[i]);
		}

	}

}

















