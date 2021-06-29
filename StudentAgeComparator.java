package comparable_ator;
import java.util.Comparator;

public class StudentAgeComparator implements Comparator<classStudent> {

	@Override
	public int compare(classStudent o, classStudent o1) {
		return o.getAge() - o1.getAge();
	}

}
