import java.util.List;
import java.util.Scanner;

/*
 * 학생 : 이름, 나이
 * 학급 : 학생이 여러명
 * 			0. 학생을 추가, 삭제 가능
 * 			1. 이름 순으로 학생목록을 콘솔창에 출력가능
 * 			2. 나이 순으로 학생목록을 콘솔창에 출력가능 
 * 			3. 나이의 평균을 콘솔창에 출력가능 
 */
class Student {
	String name;
	int age;

	public Student() {
		
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

public class Test {
	public static void main(String[] args) {

		Student s = new Student();
		_Class c =  new _Class();
		
		c.entry();
		c.sortByAge();
		c.sortByName();
	}

}





