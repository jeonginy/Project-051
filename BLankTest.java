public class BLankTest {

	public static void main(String[] args) {
		String name01 = "Jeong  in  Yun";
		
		//	Print the original value
//		System.out.println(name01);
		
		// The first way of printing 
		char [] result = delBlank(name01);
		System.out.println(result);
		String nameNew = new String(result);
		System.out.println(nameNew);
		
		// The second way of printing the name without a blank
//		String name02 = "Jeong  in  Yun";
//		System.out.println(name02.replace(" ", "") );
	
	}
	
	private static char[] delBlank( String name ) {
//		char [] name = {'Jeong', ' ', 'in', ' ','Yun' };
//		char [] newName = { 'Jeong', 'in', 'Yun' };
		
		int n = name.length();
		char [] orgName = new char[ n ];
		char [] newName = new char[ n ];
		
		for(int i = 0; i < n; i++) {
			orgName[i] = name.charAt(i);	//	get each value of characters
		}
		int pos = 0;	//	position
		for(int i = 0; i < n; i++) {
			if(orgName[i] != ' ') {
				newName[ pos + 1 ] = orgName[i];
				pos = pos + 1;
			}
		}
			return newName;
	}

}
