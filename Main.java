
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//		it means : till when find the next value right after compiling the previous one
		while(in.hasNextInt()) {
			int A = in.nextInt();
			int B = in.nextInt();
			System.out.println( A + B);
		}
	}

}
