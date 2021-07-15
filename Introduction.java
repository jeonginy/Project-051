import java.util.Scanner;

class Student {
	String name; 
	int age;
	
	public Student(String name, int age) {	
		this.name = name;
		this.age = age;
	}

	void Introduce() {		
		System.out.println( "Hi, yah- I'm " + name );
	}
}

class Teacher {
	Student[] st = new Student[10];
	
	void remember( ) {
		Scanner in = new Scanner(System.in);

		for( int i = 0; i < st.length; i++ ) {
			String name = in.nextLine();
			int age = in.nextInt();
		
			System.out.println( "Teacher : Hello, everybody. I brought you a new friend here with me" );
			System.out.println( "          " +name + " ready to meet ?");
			
			makeIntroduction( name, age);
			
			st[i] = new Student( name, age );
			
			in.nextLine();	
		}

	}

	void makeIntroduction( String newName, int newAge ) {
		if( st[0] != null ) {
		System.out.println( newName + " : Yes, Hi My dear friends? I'm " + newName + newAge + "years old" );
		}
		for( Student orist : st ) {
			if( orist == null ) {				
				break;	
			} 
			orist.Introduce();
		}
		
	}
		
}

public class Introduction {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.remember();
		
	}
}







