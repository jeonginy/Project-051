import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BufferedWriterTest{
	
	public static void main(String[] args) throws IOException {
		
//		Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다.
//		BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
//		각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
		
//		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());	// 무조건 String으로만 받음
		
		for(int i = 0; i < T; i++){		
		String a = br.readLine();					//	a에 한 줄씩 읽은 내용을 넣어줌 
		int A = Integer.parseInt(a.split(" ")[0]);	//	a를 배열 " " 로 잡고, 그 첫 번째 자리의 값 
		int B = Integer.parseInt(a.split(" ")[1]);	//	두 번째 자리의 값 
		int sum = A + B;
		
		bw.write(sum + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

//5
//1 1
//12 34
//5 500
//40 60
//1000 1000