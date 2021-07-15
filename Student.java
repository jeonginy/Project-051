public class Student {		
	//	field
	String name;
	String tel;
	int inYear;
	// consturctor
	public Student(String name, String tel, int inYear) {
		this.name = name;
		this.tel = tel;
		this.inYear = inYear;
	}
	// toString()
	@Override
	public String toString() {
		return "Student [Name =" + name + ", Mobile =" + tel + ", Admission Year =" + inYear + "]";
	}

}
