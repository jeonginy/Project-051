import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

	@Override			//	사람 2명, o1과 o2
	public int compare(Human o1, Human o2) {
		return o1.weight - o2.weight;
	}

}
class HumanScoreComparator implements Comparator<Human> {

	@Override			//	사람 2명, o1과 o2
	public int compare(Human o1, Human o2) {
		return o1.score - o2.score;
	}

}
