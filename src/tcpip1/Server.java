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
			//������� ip�ּۿ� �̸� ���� ���� �� ����//
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//7777port�� ����//�ٸ� ������� �� ��Ʈ�� ���ÿ����� �ȵ� 
		//firewall�� ������ Ư�� ��Ʈ �̿� �� ����
	}

}
