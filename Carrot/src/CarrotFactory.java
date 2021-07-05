import java.util.ArrayList;
import java.util.List;

public class CarrotFactory {
//	making carrots	
	public List<Carrots> makingCarrots (int count) {
		List<Carrots> List = new ArrayList<Carrots>();
		for(int i = 0; i < count; i++) {
			List.add(new Carrots(15));
		}
		return List;
	}
}