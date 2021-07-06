import java.util.Scanner;

class Student {
	String name;
	int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void sayhi() {
		System.out.println("반가워 나는 " + name + "이고, " + age + "살이야.친하게 지내자!");
	}
	
}

class Teacher {
	Student[] s = new Student[10];
	Scanner in = new Scanner(System.in);
	
	void remember() {
		for( int i = 0; i < s.length; i++ ) {
			String name = in.nextLine();
			int age = in.nextInt();
			
			System.out.println("오늘 새로온 친구를 소개할게요.");
		
			makesayhi(name, age);
			
			s[i] = new Student(name, age);
			in.nextLine();
		}
		
	}
	void makesayhi( String name, int age ) {
		
		if( s[0] == null ) {
			System.out.println( name + "이는 새로온 친구야.");
		} else
			System.out.println( "안녕, 난 " + name + "이고, " + age + "살이야.");
		for( Student st : s ) {
		if( st == null ) 
		 break;
		st.sayhi();
		}
	}	
	
}

public class Introduce {

	public static void main(String[] args) {
		
		Teacher t = new Teacher();
		t.remember();
		
		
	}

}
