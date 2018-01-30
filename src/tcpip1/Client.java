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
			outw= new OutputStreamWriter(outs);//2byte씩 보냄, (한국어, 중국어, 일어)
			outw.write("핫가이");
			System.out.println("Send Completed...");
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();//server가 없을 때
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();//연결이 안된다.
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
