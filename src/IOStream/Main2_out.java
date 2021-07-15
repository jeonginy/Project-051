package IOStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2_out {
	public static void main(String[] args) {
		File file = new File("./test.txt");		//	txt 파일 생성해서 내보내기 
		System.out.println(file.exists());

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);

			byte[] cbuf = "Hello, there, how's it going?".getBytes();	//	적혀진 글 그대로 파일로 생성(바이트 단위로 셈)
			
			fos.write(cbuf, 0, cbuf.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
