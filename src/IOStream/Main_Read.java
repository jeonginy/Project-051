package IOStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main_Read {
	public static void main(String[] args) throws FileNotFoundException {
		// File Input Stream
		FileInputStream fis = null;
		File file = new File("./Waybackhome.txt");
		int length = (int) file.length(); // 몇 바이트로 돼있는 지 읽어줄 길이
		try {
			fis = new FileInputStream(file);

			byte[] cbuf = new byte[length]; // byte 배열에 넣어서
			fis.read(cbuf, 0, length); // 0부터 길이까지 1 byte 씩 읽음

			System.out.println(new String(cbuf)); // byte를 String으로 변환시켜서 출력

		} catch (FileNotFoundException e) {
			e.printStackTrace(); // when not be able to find the file, throw exception
		} catch (IOException e) {
			e.printStackTrace(); // when reading the file, throw exception
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("------------------------------------------------");
		File file2 = new File("./oursong.txt"); // 읽을 파일을 가져오기
		int length2 = (int) file.length();	//	파일의 길이	
		// try-catch로 예외처리
		FileInputStream fis2 = null ; // try-catch 문 바깥에서 선언
		try {
			fis2 = new FileInputStream(file2); // 예외 발생시 catch문으로 감 -> try 문 안의 문장 실행 안될 수 있음
			
			byte[] cbuf2 = new byte[length];	//	길이만큼 배열에 byte 집어넣기 
			
		
				fis2.read(cbuf2, 0, length);
				System.out.println(new String(cbuf2));
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			if(fis2 != null) {		//	fis가 초기화됐을 경우, 닫아주기 
				try {
					fis2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
//			fis.close(); // try블럭 안에 선언돼있기 때문에, {}안에 포함시켜야 함
		}
	}
}
