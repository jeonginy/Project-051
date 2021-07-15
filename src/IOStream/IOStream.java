package IOStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class IOStream {
	public static void main(String[] args) {
		FileInputStream in = null;		//	read by byte
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("Somesay.txt");
			out = new FileOutputStream("Copy_Somesay.txt");		//	read 'Somesay.txt'and create another one 
			
			int c;
			while((c = in.read()) != -1) {	//	read by byte
				System.out.println("The Character reader read : " + (char)c);
				out.write(c);	//	write by byte
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {	
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}