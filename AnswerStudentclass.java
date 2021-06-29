
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerStudentclass {
/*		Student : name, age
*		ClassRoom : students
*			0.	add or remove students
*			1.	print by name
*			2.	print by age
*			3.	print the average of age
*/	
	public static void main(String[] args) {
		
		classStudent s0 = new classStudent("d",7);
		classStudent s1 = new classStudent("a",10);
		classStudent s2 = new classStudent("b",8);
		classStudent s3 = new classStudent("c",9);
		
		ClassRoom room = new ClassRoom();
		
		room.add(s0);
		room.add(s1);
		room.add(s2);
		room.add(s3);
		
		room.printByName();
		room.printByAge();
		room.printAvgAge();
		
		
		System.out.println(s1.compareTo(s2));	// -
		System.out.println(s2.compareTo(s1));	// +
		
	}

}
