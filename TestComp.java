import java.util.Scanner;
public class TestComp {
	public static void main(String[] args) {
		
		Scanner  in  = new Scanner(System.in);
		
		int a1  = 10;
		int a2  = 5 + 5;
		
		if(a1 == a2)  // compare values
			System.out.println("Same");
		else
			System.out.println("Different");

// ---------------------------------------------------------------
		
		String  s1 = "Anna";
		String  s2 = "Elsa";
		if(s1 == s2)  // not proper way of comparing values 
			System.out.println("Same");
		else
			System.out.println("Different");
		
// ---------------------------------------------------------------
		
		String  s3 = "Anna";
		String  s4;
		System.out.println("Name :");
		s4 = in.nextLine();
		if(s3 == s4) //  comparing the address of two values   
			System.out.println("Same");
		else
			System.out.println("Different");
		
		if( s3.equals(s4) )  // comparing the data values
			System.out.println("Same");
		else
			System.out.println("Different");
		
		// comparison "String" : compareTo("Anna", "Elsa"); 
		// >   0 
		// ==  0 
		// <   0 
		if( s3.compareTo(s4) == 0 )  
			System.out.println("Same");
		else
			System.out.println("Different");
		
		String  s5 = new String("Anna");
		String  s6 = new String("Anna");
		if( s5 == s6 ) 
			System.out.println("Same");
		else
			System.out.println("Different");
		if( s5.compareTo(s6) == 0 )  
			System.out.println("Same");
		else
			System.out.println("Different");

		
	}

}








