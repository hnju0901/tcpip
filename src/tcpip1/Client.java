package tcpip1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		String ip = "70.12.111.130";
		
		int port = 7777;
		Socket socket = null;
		OutputStreamWriter outw=null;
		OutputStream outs=null;
		try {
			System.out.println("Start Client...");
			socket = new Socket(ip, port);
			System.out.println("Connection OK...");
			
			// Send Data...
			outs = socket.getOutputStream();
			outw= new OutputStreamWriter(outs);//2byte�� ����, (�ѱ���, �߱���, �Ͼ�)
			outw.write("�ְ���");
			System.out.println("Send Completed...");
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();//server�� ���� ��
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();//������ �ȵȴ�.
		} finally {
			try {
				outw.close();
				outs.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
}
