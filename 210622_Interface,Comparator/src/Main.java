import java.util.Arrays;

class Human implements Comparable<Human> {

	@Override
	public String toString() {
		return "Human [height=" + height + ", weight=" + weight + "]";
	}

	int height;
	int weight;
	int score;

	public Human(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Human o) {
		return this.height - o.height;
	}

//	@Override
//	public int compareTo(Object o) {
//		Human other = (Human)o;
//		if( this.height > other.height ) {
//			return 1;
//		} else if( this.height < other.height ) {
//			return -1;
//		}
//		return 0;
//	}

}

public class Main {

	public static void main(String[] args) {

		Human h = new Human(180, 70);
		Human h2 = new Human(170, 77);
		Human h3 = new Human(175, 72);

//		System.out.println(h.compareTo(h2));

//		(예시)
//		int[] arr = { 30, 3, 2, 55, 44 };
//		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));	->	숫자를 문자열로 뽑아냄

		Human[] human = { h, h2, h3 };
		Arrays.sort(human);
		System.out.println(Arrays.toString(human));	//	키 순으로 배열 

		HumanScoreComparator scom = new HumanScoreComparator();
		HumanComparator com = new HumanComparator();
//		System.out.println(com.compare(h, h2));		//	12 ; h가 h2보다 12키로 더 큼(양수) - 몸무게 순으로 배열
		Arrays.sort(human, com);	//	몸무게의 대소비교 기준으로 정렬 
		System.out.println(Arrays.toString(human));
		
		
	}

}





