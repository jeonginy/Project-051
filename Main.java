import java.util.Scanner;
/*	회원 : 이름 나이 전화번호
 *  콘솔 프로그램 (입/출력)
 *  1.회원 등록 - 이미 등록된 회원은 X, 전화번호 중복되면 안됨
 *  2.회원 목록
 *  3.회원 삭제
 *  4.회원 정보 수정
 *  1 - register, 2 - list of members, 3 - delete account, 4 - edit the details
 *  duplication not accepted by mobile phone number 
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Programme pr = new Programme();
		boolean check = true;
		
		while (check) {
			System.out.println("1 - register, 2 - list of members, 3 - delete account, 4 - edit the details");
			int n = in.nextInt();

			switch (n) {
			case 0:
				check = false;
				break;
			case 1:
				pr.inputMembers();
				break;
			case 2:
				pr.listOfMemebers();
				break;
			case 3:
				pr.deleteMemebers();
				break;
			case 4:
				pr.editMembers();
				break;
			}
		}

	}

}
