package comparable_ator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassRoom {
//	1) be able to use function of ArrayList -> Not recommended : clear(one of the function from ArrayList) makes everything gone
//	class ClassRoom extends ArrayList {
	
//	2) has-a relation : to use functions from ArrayList(add, remove, sort etc)
		private List<classStudent> list = new ArrayList<>();

//	Add 
		void add(classStudent student) {
			list.add(student);
		}

//	Delete
		void remove(classStudent student) {
//		void remove(indexNumber) is okay, too
			list.remove(student);

		}

//	print by name(having 'list class') : do not need to fill out the List as a new 
		void printByName() { // Compare classStudent each other
			List<classStudent> copy = new ArrayList<>(list); //  copy of the list > clone - be able to edit
			Collections.sort(copy);
			System.out.println(copy);
		}

//	print by age
		void printByAge() {
			List<classStudent> copy = new ArrayList<>(list);
			Collections.sort(copy, new StudentAgeComparator());
			System.out.println(copy);
		}

//	print the average of age
		void printAvgAge() {
			int sum = 0;
			for( int i = 0; i < list.size(); i++ ) {
				list.get(i);
			}
		}


	}

