package IOStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
/*
 * Write the contents which users input 
 */
public class Main_3 {
	public static void main(String[] args) {
		File file = new File("Hello.txt");
		
		FileWriter fw  = null;
//		BufferedWriter br = new BufferedWriter(new OutputStream(System.in));
		
		try {
			fw = new FileWriter(file);
			
			Scanner in = new Scanner(System.in);
			String text = in.nextLine();
			
			fw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
