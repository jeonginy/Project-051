public class TestForPaging1 {
	public static void main(String[] args) {
		int totPage     = 26;
		int pagePerLine = 10;
		System.out.print("    ");
		for (int i = 1; i <= totPage ; i++) {					
			System.out.printf("%3d " , i );
			if(  i % 10 == 0  ) {
				System.out.print("> >>");
				System.out.print("\n");
				System.out.print("< <<");
			}
		}

	}

}


