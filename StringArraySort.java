public class StringArraySort {
	public static void display(String[] strArr) {
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i] + " ");
		}
		System.out.println();
	}

	public static void bubblesort(String[] strArr) {
		int n = strArr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
		// String vl =  strArr[j].compareTo(strArr[j+1])
				if( strArr[j].compareTo(strArr[j+1]) > 0 ) {
					String tmp = strArr[j];
					strArr[j] = strArr[j+1];
					strArr[j+1] = tmp;
				}
			}
		}
		
	}

}
