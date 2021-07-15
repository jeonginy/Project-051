import java.util.Scanner;
public class TestNationalId {
	public static void main(String[] args) {
		Scanner  in = new Scanner(System.in);
		System.out.println("NationalID(123456-7890123):");
	//	String  nationalId = "123456-7890123";
		String  nationalId = in.nextLine(); //"123456-1234563";
		boolean result = NationalIdCheck( nationalId );
		if( result )
			System.out.println("Varified NationalID");
		else
			System.out.println("Wrong NationalID");
	}
	private static boolean NationalIdCheck(String nationalId) {
		String [] nids     =  nationalId.split("-");
		// nids[0] :  "123456"
		// nids[1] :  "7890123"
		int []  m1  = { 2, 3, 4, 5, 6, 7 };
		int []  m2  = { 8, 9, 2, 3, 4, 5 };
		int []  n1 = new int[6];
		int []  n2 = new int[7];
	//  substring(beginning(0), end(1):1-1 );  012345
	//                                     // "123456"
		/*
		n1[0] = Integer.parseInt( nids[0].substring(0, 1) ); // 1
		n1[1] = Integer.parseInt( nids[0].substring(1, 2) ); // 2
		n1[2] = Integer.parseInt( nids[0].substring(2, 3) ); // 3
		n1[3] = Integer.parseInt( nids[0].substring(3, 4) ); // 3
		n1[4] = Integer.parseInt( nids[0].substring(4, 5) ); // 3
		n1[5] = Integer.parseInt( nids[0].substring(5, 6) ); // 3
		*/
		for(int i = 0;i < n1.length; i++ ) {
			n1[i] = Integer.parseInt( nids[0].substring(i, i+1) );
		}
		for (int i = 0; i < n2.length; i++) {
			n2[i] = Integer.parseInt( nids[1].substring(i, i+1) ); 
		}
		/*
		tot = tot + n1[0]* m1[0];
		tot = tot + n1[1]* m1[1];
		tot = tot + n1[2]* m1[2];
		tot = tot + n1[3]* m1[3];
		tot = tot + n1[4]* m1[4];
		tot = tot + n1[5]* m1[5];
		*/
		int tot = 0;
		for (int i = 0; i < m1.length; i++) {
			tot = tot + n1[i] * m1[i];			
		}
		for (int i = 0; i < m2.length; i++) {
			tot = tot + n2[i] * m2[i];			
		}
		System.out.println(tot);  // 272
		int na = 11 - tot % 11;
		na = na % 10;
		System.out.println(na);
		boolean result = false;
		if(na == n2[6] ) 
			result = true;
		if( n2[0] % 2 == 1  ) {
			System.out.println("Male");
		} else {
			System.out.println("Female");
		}
		return result;
	}
}
