package IOStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) {
		FileReader fr = null;		//	read by character  <->  input|output : byte 
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Waybackhome.txt");
			fw = new FileWriter("Copy_Waybackhome.txt");		//	read 'Waybackhome.txt'and create another one 
			
			int c;
			
			while((c = fr.read()) != -1) {	//	read by character
//				= from the beginning to the end
				fw.write(c);	//	write by character
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null) {	//	file get full, close the file
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}