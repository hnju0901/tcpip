package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//server에 connection 시도
//socket생성
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
			// Runable은 thread 객체에 넣고 실행시킴. thread는 그냥 객체생성해서 실행시킴//
			System.out.println("client:"+msg);
			sender.setSendMsg(msg);
			t.start();// run함수가 실행됨//
		}
		System.out.println("Exit Chatting...");
	}
	// Message Sender............................................
	class Sender implements Runnable {
		OutputStream out;
		DataOutputStream dout;// uni code가 지원되는 것
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

		// 메세지 받을 것 대기하고 있어야해//
		@Override
		public void run() {
			while (true) {
				String msg = null;
				try {
					msg = din.readUTF();// 여기서 대기//
					System.out.println("server:"+msg);
				} catch (IOException e) {
					System.out.println("Exit Server User...");
					break;
				}
			}
		}
	}
}
