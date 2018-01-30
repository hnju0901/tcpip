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
		BufferedReader br = null;// �������� �޸� �ȿ��� ������ string�� ���κ�, ���庰�� ���� �� ����//
		
		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			// ������� ip�ּۿ� �̸� ���� ���� �� ����//
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
		// 7777port�� ����//�ٸ� ������� �� ��Ʈ�� ���ÿ����� �ȵ�
		// firewall�� ������ Ư�� ��Ʈ �̿� �� ����
	}

}
