import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class TextWriter {
	public static void main(String[] args) throws IOException {
		//	create a new file & a path to get the information
		//  make sure the path of the file want to input
		String filename  = "/Users/jeongin_yun/mc/new1.txt";
		//String filename  = "/Users/hth/imsi/new1.txt";
		File   outFile   = new File( filename ); 
		
		FileWriter  fw1  = new FileWriter( outFile );
		
		// get ready to add names
		String  [] names = { "Jeongin", "Eury", "BTS", "J.Fra", "Davide", "Ian" };
		
		String  msg = "";  
		int     cnt = 0;
		for(int i=0;i<names.length;i++) {
			msg = String.format("%d %s\n", i, names[i]);
			fw1.write( msg );
			cnt++ ;
		}
		
		
		fw1.close();
		System.out.println(cnt + "Saving is completed");
		
		

	}

}








