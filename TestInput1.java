import java.util.Date;
import java.util.Scanner;

public class TestInput1 {
	// Input : num, name, email, hire date, department number 
	// Output : num, name, email, hireYears, deptName, position  
	static  String  num;
	static  String  name;
	static  String  email;	
	static  int     hiredate;
	static  int     deptno; 
	
	static  int     hireYears;
	static  String  deptName;
	static  String  position;
	
	public static void main(String[] args) {
	   	input();
	   	process();
	   	output();
	}

	private static void input() {
		Scanner in = new Scanner(System.in);		
		System.out.println("Input your identification number, name, email, hire date, department number  :");
		String line = in.nextLine();
		
		String [] data = line.split(",");
		
		num      =  data[0].trim();
		name     =  data[1].trim();
		email    =  data[2].trim();
		hiredate =  Integer.parseInt( data[3].trim() );
		deptno   =  Integer.parseInt( data[4].trim() );
		
	}
	private static void process() {
		//  Length of service  <-  Hire Year
		Date   today = new  Date();
		int thisYear = today.getYear( ) + 1900;
		System.out.println( "This Year" + thisYear );
		hireYears =  thisYear  - hiredate/10000;
				
		//  Department Name    
		String [] dName = {
			"Human Resources", "General Affair", "The Materials Division", "Research&Develope", "Production"
		};
		//	Department Number
		int idx = 0;
		switch(deptno) {
		case 10: idx = 0; break;
		case 20: idx = 1; break;
		case 30: idx = 2; break;
		case 40: idx = 3; break;
		case 50: idx = 4; break;
		}
		//	position  <--  department name
		deptName  = dName[ idx ];
		position = "";
		
		if( hireYears > 20 ) position = "Adviser";
		else if( hireYears >= 15  ) position = "Director";
		else if( hireYears >= 10  ) position = "Senior Manager";
		else if( hireYears >= 5  ) position = "Junior Manager";
		else if( hireYears >=3  )  position = "Assistant";
		else if( hireYears < 3  )  position = "Employee";
		
	}

	private static void output() {
		System.out.println(
			"ID number  name       email          hire Years   department Name  position");
		
		System.out.printf("%6s   %5s  %-20s   %4d    %6s   %4s\n", 
			num, name, email, hireYears, deptName, position	);
		
	}

}

//		0512,Jeongin,jeonign0520@naver.com,2010,10








