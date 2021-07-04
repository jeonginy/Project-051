

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class OtherSets {

	public static void main(String[] args) {
		
//		an ordered version of HashSet that maintains a doubly-linkedList across all elements.
//		When the iteration order is needed to be maintained this class is used
		Set<String> set = new LinkedHashSet<>();	 
		set.add("Banana");
		set.add("Apple");
		set.add("Durian");
		set.add("Carrot");
		
		System.out.println(set);
		
//		The ordering of the elements is maintained by a set using their natural ordering,
//		whether or not an explicit comparator is provided
//		All elements inserted into the set must implement the Comparable interface. 
		Set<String> set2 = new TreeSet<>();		
		set2.add("Banana");
		set2.add("Carrot");
		set2.add("Durian");
		set2.add("Apple");
		
		System.out.println(set2);
		
	}

}
