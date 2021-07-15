import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//	Lotto 
//	print Random numbers without duplication 

public class Lotto {
	public static void main(String[] args) {
		// Interface - Set 
		/*
		 * Set<Integer> mySet = new HashSet<>(); System.out.println(mySet.add(10));
		 * System.out.println(mySet.add(5)); System.out.println(mySet.add(7));
		 * System.out.println(mySet.add(8)); // When to add the new value, the result is true 
		 * System.out.println(mySet.add(1));
		 * System.out.println(mySet.add(1)); // When gets the duplicated value, it returns false
		 * System.out.println(mySet);	print randomly, not ordered 
		 * 
		 * 
		 * Iterator<Integer> iterator = mySet.iterator(); while(iterator.hasNext()) {
		 * System.out.println(iterator.next()); 
		 * } for( Integer i : mySet ) {
		 * System.out.println(i);
		 * }
		 */
		
		Random r = new Random();
//		int  num = r.nextInt(10) + 1;		

		Set<Integer> lotto = new HashSet<>();
		while (lotto.size() < 6) {	
			lotto.add(r.nextInt(10) + 1);	
			}
		System.out.println(lotto);
	}
//		int[] lotto = new int[6];
//		for(int i = 0; i < lotto.length; i++) {	
//			lotto[i] = r.nextInt(10) + 1;		//	 to avoid duplication, use Set
//			
//		}
//		System.out.println(Arrays.toString(lotto));
//		
}
