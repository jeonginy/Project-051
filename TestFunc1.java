import java.util.Scanner;

// function
// return 
// 1. Exit the process
// 2. Return the value
public class TestFunc1 {

	public static String input() {
		System.out.println("input");	
		
		Scanner  in = new Scanner(System.in);
		System.out.println("Name(in lower-case) :");
		
		String name = in.nextLine(); 
		return name;
	}
	
	public static String process( String irum  ) {
		System.out.println("process");
		// lower-case -> upper-case
		String r  =  irum.toUpperCase();   
		return r;		
	}
	
	public static void output( String result ) {
		System.out.println("output");	
		System.out.println( result );
	}
	
	// process( name )
	// name : parameter, argument
	public static void main(String[] args) {
	    		
		String name = input();	
		// System.out.println("main:" + name);
		String  result =  process( name );
		output( result );
		
	}

}










