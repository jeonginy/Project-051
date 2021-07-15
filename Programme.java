import java.util.*;
public class Programme {

// 회원 정보를 담을 그릇 준비: get ready Member List 	be able to remove duplication
	Set<Members> list = new HashSet<Members>();		//	중복된 값을 제거하고 원소들을 정렬할 수 있다  
	static Scanner in = new Scanner(System.in);

// 회원 정보 입력 : input the info of Members

	public void inputMembers() {
		System.out.println("input your details(name, age, mobile phone number) : ");

		String name = in.nextLine(); // "Jeongin", "Seho", "Eury", "HyeonMin", "Junseok"
		int age = in.nextInt(); // 26, 33, 35, 30, 26
		in.nextLine();
		String num = in.nextLine(); // "010-4342-5523", "010-1234-5678", "010-5678-7890", "010-4629-7688","010-4321-9876"

		Members member = new Members(name, age, num);

		if (!list.add(member)) {
			System.out.println("duplicated");

		}
	}

// 회원 목록	: the list of members
	public void listOfMemebers() {
		Iterator<Members> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("This is our present list of precious members^_^");
	}

// 회원 삭제 : delete account
	public void deleteMemebers() {
		System.out.println("input the information which you want to delete");
		String name = in.nextLine();
		Iterator<Members> itr = list.iterator();
		while (itr.hasNext()) {
			Members out = itr.next();
			if (out.getName().equals(name)) {
				itr.remove();
				System.out.println("Thanks for your previous join our service");
			}
		}
		System.out.println(list);
	}

// 회원 정보 수정 : edit the details of the info
	public void editMembers() {
		System.out.println("input the information which you want to change");
		String name = in.nextLine();
		String newName = in.nextLine();
		int age = in.nextInt();
		String num = in.nextLine();

		Iterator<Members> itr = list.iterator();
		while (itr.hasNext()) {
			Members out = itr.next();
			if (out.getName().equals(name)) {
				out.setName(newName);
				out.setAge(age);
				out.setNum(num);
				System.out.println("your information has changed completely ^>^");
			}
		}
	}

}
