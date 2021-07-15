import java.io.File;
import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) {
//		when createFile method throws exception to main, must do try-catch instead
//		try {
		File f = createFile(args[0]);
		System.out.println(f.getName() + "New file is completely created");
//		} catch (Exception e) {
//		System.out.println(e.getMessage() + "input again please");
	}
//	}

	static File createFile(String fileName) { // throws Exception {
		try {
			if (fileName == null || fileName.equals(""))
				throw new Exception("This fileName is not valid");	

		} catch (Exception e) {
			fileName = "No Content.txt";
		}
		File f = new File(fileName);	//	create instance of File
		try {
			f.createNewFile();			//	create an actual file using createNewFile method 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return f;
	}

}
