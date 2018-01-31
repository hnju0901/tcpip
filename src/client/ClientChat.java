package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//server�� connection �õ�
//socket����
public class ClientChat {
	String ip;
	int port;
	Socket socket ;
	Scanner scanner;

	public ClientChat() {

	}

	public ClientChat(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			socket = new Socket(ip, port);
			System.out.println("Connected Server ..");
			start();
		} catch (IOException e) {
			System.out.println("Connected Refused ..");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() throws IOException {
		scanner = new Scanner(System.in);
		
		Receiver receicver = new Receiver();
		receicver.start();
		
		while (true) {
			Sender sender = new Sender();
			Thread t = new Thread(sender);
			System.out.println("Input Client Messae ..");
			String msg = scanner.nextLine();
			if (msg.equals("q")) {
				scanner.close();
				sender.close();
				break;
			}
			// Runable�� thread ��ü�� �ְ� �����Ŵ. thread�� �׳� ��ü�����ؼ� �����Ŵ//
			System.out.println("client:"+msg);
			sender.setSendMsg(msg);
			t.start();// run�Լ��� �����//
		}
		System.out.println("Exit Chatting...");
	}
	// Message Sender............................................
	class Sender implements Runnable {
		OutputStream out;
		DataOutputStream dout;// uni code�� �����Ǵ� ��
		String msg;

		public Sender() throws IOException {
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
		}

		public void setSendMsg(String msg) {
			this.msg = msg;
		}
		public void close() throws IOException {
			dout.close();
			out.close();
		}

		@Override
		public void run() {
			try {
				
				if (dout != null) {
					dout.writeUTF(msg);
				}
				
			} catch (IOException e) {
				System.out.println("Not Available! Exit Server User....");
			}
		}
	}
	// Message Receiver .....................................
	class Receiver extends Thread {
		InputStream in;
		DataInputStream din;

		public Receiver() throws IOException {
			in = socket.getInputStream();
			din = new DataInputStream(in);
		}

		public void close() throws IOException {
			din.close();
			in.close();
		}

		// �޼��� ���� �� ����ϰ� �־����//
		@Override
		public void run() {
			while (true) {
				String msg = null;
				try {
					msg = din.readUTF();// ���⼭ ���//
					System.out.println("server:"+msg);
				} catch (IOException e) {
					System.out.println("Exit Server User...");
					break;
				}
			}
		}
	}
}
