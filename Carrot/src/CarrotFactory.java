import java.util.ArrayList;
import java.util.List;

public class CarrotFactory {
//	making carrots	
	public List<Carrot> makingCarrots (int count) {
		List<Carrot> List = new ArrayList<Carrot>();
		for(int i = 0; i < count; i++) {
			List.add(new Carrot(15));
		}
		return List;
	}
}
 