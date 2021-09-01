package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		Socket socket = null;
		socket = new Socket("localhost", 7777);
		System.out.println(socket + "연결됨");

		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();

		byte[] b = new byte[1024];
		int length = System.in.read(b);

		// 키보드 입력을 바이트단위로 읽어 b 라는 바이트 배열에 기록 후,
		// 읽은 바이트 수를 리턴함(읽을 값이 없으면 대기, -1이면 종료)
		// 스트림의 끝인 경우 -1을 리턴함

		while ((length != -1)) {
			out.write(b, 0, length);
			length = in.read(b);
			System.out.write(b, 0, length);
			
		}
		out.close();
		
		System.out.println(socket + "연결 종료");
		socket.close();
	}
}
