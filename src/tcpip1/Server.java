package tcpip1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			//사용자의 ip주송와 이름 정보 얻을 수 잇음//
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//7777port로 들어와//다른 사람들이 한 포트로 동시연결은 안됨 
		//firewall로 막으면 특정 포트 이외 다 막음
	}

}
