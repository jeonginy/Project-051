import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BufferedWriterTest{
	
	public static void main(String[] args) throws IOException {	//	watch out for exception 
		
//		Using BufferedReader & BufferedWriter instead of Scanner & System.out.println
//		Put on BufferedWriter.flush at last
//		Print A & B on each line 
		
//		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++){		
		String a = br.readLine();					
		int A = Integer.parseInt(a.split(" ")[0]);	 
		int B = Integer.parseInt(a.split(" ")[1]);	 
		int sum = A + B;
		
		bw.write(sum + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
// An example 
//5
//1 1
//12 34
//5 500
//40 60
//1000 1000

