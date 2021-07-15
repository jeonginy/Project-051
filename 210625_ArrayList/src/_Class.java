import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _Class {

	List<Student> _class = new ArrayList<>();
	
	
	public void entry() {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String name = in.nextLine();
			int age = in.nextInt();

			System.out.println( name + "님이 입장하셨습니다.");
			System.out.println(" " + name + "입니다." + age + "살이예요. 반가워요^0^ ");
			
			in.nextLine();
			_class.add(new Student(name, age));
			System.out.println(_class.get(i));
		}
	}

	public void sortByName() {
		for (int i = 0; i < _class.size() - 1; i++) {
			for (int j = i + 1; j < _class.size(); j++) {
				if (_class.get(i).getName().compareTo(_class.get(j).getName()) > 0) {
				Student tmp = _class.get(i);
				_class.set(i, _class.get(j));
				_class.set(j, tmp);
				
				}
			}
		}
		System.out.println(_class);
	}

	public void sortByAge() {
		for (int i = 0; i < _class.size() - 1; i++) {
			for( int j = i+1; j <  _class.size(); j++ ) {
				if(_class.get(i).getAge() > _class.get(j).getAge()) {
					Student tmp = _class.get(i);
					_class.set(i, _class.get(j));
					_class.set(j, tmp);
				}
			}
		}
		System.out.println(_class);
	}

}
