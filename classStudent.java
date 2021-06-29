package comparable_ator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//	comparable<>
public class classStudent implements Comparable<classStudent> {

	private String name;
	private int age;

	public classStudent(String name, int age) {
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
		return "classStudent [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(classStudent o) {
		// 이름 순으로 대소 비교
		return this.name.compareTo(o.name);
	}

}	
	

