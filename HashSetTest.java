import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

		Set<Integer> union = new HashSet<>();
		union.addAll(set1);	//	add All components except for duplicated one
		union.addAll(set2);
		System.out.println("union : " + union);
		
		Set<Integer> duplicate = new HashSet<>(set1);
		duplicate.retainAll(set2);	//	all only duplicated one
		System.out.println( "intersection of sets : " + duplicate);
		
		Set<Integer> outersector = new HashSet<>(union);
		outersector.removeAll(duplicate);	// remove intersection parts
		System.out.println(outersector);
		
	}

}
