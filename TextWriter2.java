import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TextWriter2 {
	public static void main(String[] args) throws IOException {
		String          filename = "/Users/jeongin_yun/mc/indata.txt";
		File            file1    = new File(filename);  
		FileWriter      fw1      = new FileWriter( file1 );
		BufferedWriter  bw1      = new BufferedWriter(fw1);  // sort of boost or support FileWriter function
		
		Scanner in  = new Scanner(System.in);
		
		System.out.println("Number, Name, Korean, English, Math");
		System.out.println("Exit");
		
		int cnt = 0;
		while( true ) {  // infinite loop
			String  line  =  in.nextLine();
			if( line.equalsIgnoreCase( "Exit") )
				  break; //	out of the loop
			
			writeData(bw1, line);
			cnt++;
		}
		
		in.close();
		bw1.close();
		fw1.close();
		System.out.println(cnt + "Saving is completed");
	}

/*
1,Jeongin,100,100,100
2,Eury,90,90,90
3,Davide,100,90,80
4,Ian,100,90,9
Exit
*/
	
	private static void writeData(BufferedWriter bw1, String line) 
			throws IOException {
		
		String []  li   = line.split(",");
		int        num  = Integer.parseInt( li[0] );  
		String     name = li[1].trim() ;  
		int        kor  = Integer.parseInt( li[2] );  
		int        eng  = Integer.parseInt( li[3] );  
		int        mat  = Integer.parseInt( li[4] );  
		int        tot  = kor + eng + mat;
		int        avg  = tot / 3;
		
		String  fmt = "%4d %6s  %3d %3d %3d %3d %3d\n";
		String  msg = String.format(fmt, 
			num, name, kor, eng, mat, tot, avg	);
		
		bw1.write( msg ); 
		
	}

}













