import java.util.Objects;
public class Members {
	private String name;
	private int age;
	private String num;
	
	public Members(String name, int age, String num) {
		this.name = name;
		this.age = age;
		this.num = num;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "name of members : " + name + ", age : " + age + ", mobile phone number : " + num ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num);	//	compared by mobile phone number : 번호로 구분짓는 다는 것을 지정 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Members))
			return false;
		Members other = (Members) obj;
		return num.equals(other.num);		// declared String, should use equals for comparison
	}
	
}
