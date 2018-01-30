package tcpip1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		InputStreamReader inr = null;
		BufferedReader br = null;// 일정량의 메모리 안에서 들어오는 string을 라인별, 문장별로 읽을 수 있음//
		
		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			// 사용자의 ip주송와 이름 정보 얻을 수 잇음//
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			System.out.println("Strat Server ....");
			while (true) {
				socket = serverSocket.accept();
				System.out.println("Client Connected ..");
				// Receive Data ...
				in = socket.getInputStream();
				inr = new InputStreamReader(in);
				br = new BufferedReader(inr);
				String receiverStr = br.readLine();
				System.out.println(receiverStr);
				System.out.println("End Server...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				inr.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 7777port로 들어와//다른 사람들이 한 포트로 동시연결은 안됨
		// firewall로 막으면 특정 포트 이외 다 막음
	}

}
