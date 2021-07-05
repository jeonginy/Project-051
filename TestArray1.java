import java.util.ArrayList;
public class TestArray1 {
	public static void main(String[] args) {
		// List of names
		String [] names= {"Charile", "Mark", "Kary", "Leann"};
		
		for (int i = 0; i < names.length; i++) {
			System.out.println( names[i] );
		}
		// names[4] = "Gena"; // Error : ArrayIndexOutOfBound 
		System.out.println("==========================");
		// to add the name of Gena
		// Once create array, not be allowed to edit(add, remove) the elements in Array
		//	Thus, use ArrayList !
		ArrayList friends  = new ArrayList(); 
		friends.add("Charile");  // size() : 0
		friends.add("Mark");	 // size() : 1
		friends.add("Kary"); 	 // size() : 2
		friends.add("Leann");    // size() : 3

		output( friends );		
		friends.add("Gena"); // size() : 4
		output( friends );	
		friends.remove( 3 );	//	remove index[3]
		output( friends );	
	
	}
	private static void output(ArrayList friends) {
		for (int i = 0; i < friends.size(); i++) {
			System.out.println( i + ":" +  friends.get(i) );
		}
		System.out.println("=========================");
		
	}

}











