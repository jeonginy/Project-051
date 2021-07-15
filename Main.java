import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] arr = new int[N]; // create Array having
		for (int i = 0; i < N; i++) { // to store the values of arr
			arr[i] = in.nextInt();
		}

		int max = arr[0]; // declared maximum and minimum value at first
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) { // to find the maximum value and minimum value
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}

		}
		System.out.print(min + " " + max);

	}

}
