package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//	Thread를 상속받든지, Runnable interface를 구현해서 쓰레드 사용 가능 
public class MyThread extends Thread {
	private Socket socket; // 클라이언트가 접속하려고 시도할 때 accept를 해서 연결시키기 위해 사용

	public MyThread(Socket socket) {
		this.socket = socket;

	}

	// 쓰레드가 수행할 행동 적어주기
	@Override
	public void run() {
		System.out.println(socket + ": Connected with client successfully");
		try {
			// socket을 받아들여서 input/output을 할 변수 만듦
			InputStream fromClient = socket.getInputStream();
			OutputStream toClient = socket.getOutputStream();

			// 클라이언트가 보낸 값을 받아서 읽고 보내기
			byte[] b = new byte[1024];
			int length = fromClient.read(b); // InputStream으로 받은 byte 배열의 값을 한 바이트로 읽어서
												// b에 넣기
												// 원래는 읽을 값이 없으면 대기
			while (length != -1) { // -1 이 리턴되면 프로그램 종료
				toClient.write(b, 0, length); //
				System.out.write(b, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);

			// 클라이언트가 들어오는 것을 기다리기 위해서 계속 기다림
			while (true) {
				// 클라이언트를 받아들일 소켓을 받아들일 변수 생성
				Socket client = server.accept(); // ServerSocket + accept -> queue에 쌓여있는 클라이언트의 요청 받아들임
													// 소켓 생성 후, 클라이언트 쪽 소켓이랑 값을 주고 받게 함
													// socket을 parameter로 주고 쓰레드를 상속받은 Server클래스 생성 즉, = 쓰레드임
				MyThread myServer = new MyThread(client);
				myServer.start(); // 상속받은 쓰레드를 시작 : 클라이언트 상대 시작 main thread가 돌아가고 있는 중에

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
