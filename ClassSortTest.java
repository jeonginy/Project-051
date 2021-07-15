class IntArraySort {
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void bubblesort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];	//	swap();
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
					
			}
		}
	}
	
}


public class ClassSortTest {

	public static void main(String[] args) {
		int [] arr = new int[] { 8, 3 ,9, 7, 2 };
		IntArraySort.display(arr);
		IntArraySort.bubblesort(arr);
		IntArraySort.display(arr);
		
		String [] strArr = new String[] {
				"Jeongin","Juhee", "Changjun", "Minho", "Eury"
		};
		
		StringArraySort.display(strArr);
		StringArraySort.bubblesort(strArr);
		StringArraySort.display(strArr);
		
		Student [] std = new Student[] {
		
		new Student	("Jeongin", "010-1111-2222", 2010),	//	Constructor
		new Student	("Juhee", "010-3333-2222", 2014),
		new Student	("Changjun", "010-4444-2222", 2014),
		new Student	("Minho", "010-5555-2222", 2013),
		new Student	("Eury", "010-2222-3333", 2004)
		};
		System.out.println("-----------------------------------------------");
		//	Align by array

		StudentArraySort.display( std );		// Student [] print
		System.out.println("-----------------------------------------------");
/*		int op = 1; 	//	op : 1 - Name , op : 2 - Mobile, op : 3 - Admission Year
		StudentArraySort.bubbleSort( std, op );	// Student [] sort
		StudentArraySort.display( std );	// Student [] print 
*/
		
		int op = 2; 	//	op : 1 - Name , op : 2 - Mobile, op : 3 - Admission Year
		StudentArraySort.bubbleSort( std, op );	// Student [] sort
		StudentArraySort.display( std );	// Student [] print

/*		int op = 3; 	//	op : 1 - Name , op : 2 - Mobile, op : 3 - Admission Year
		StudentArraySort.bubbleSort( std, op );	// Student [] sort
		StudentArraySort.display( std );	// Student [] print
*/
	
	}	
}

// ***** important to notice the different Student Student to Student array *****
 
class StudentArraySort{

	public static void display(Student[] std) {
		for(int i = 0; i < std.length; i++) {
			System.out.println( std[i].toString( ));
		}
		
	}

	public static void bubbleSort( Student[] std, int op ) {
		int n = std.length;
		for(int i = 0; i < n-1; i++) {
			for(int j =0; j < n-1-i; j++ ) {
				switch(op) {
				case 1: 		//	Name
					if( std[j].name.compareTo(std[j+1].name) > 0 ){
						Student tmp = std[j];
						std[j] = std[j+1];
						std[j+1] = tmp;
					}
					break;
					case 2: 		//	Mobile
						if( std[j].tel.compareTo(std[j+1].tel) > 0 ){
							Student tmp = std[j];
							std[j] = std[j+1];
							std[j+1] = tmp;
						}
						break;
						case 3: 	//	Admission Year
							if( std[j].inYear > std[j+1].inYear ){
								Student tmp = std[j];
								std[j] = std[j+1];
								std[j+1] = tmp;
							}
							break;
					}
			
				}
			}
		
		}
	
	}
		
	
	
	
	
	





