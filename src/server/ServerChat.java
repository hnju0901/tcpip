package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//server에 connection 시도
//socket생성
public class ServerChat {
	ServerSocket serverSocket;//server만 들어갈 수 있는 공간
	Socket socket;//공간-string int등 다 받을 수 있음-serverSocket을 받아서 server사용. 
	Scanner scanner;
	
	public ServerChat() {	 }
	public ServerChat(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Ready Server ...");
			start();
		} catch (IOException e) {
			System.out.println("연결 망했네 ...");
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void start() throws IOException {
		socket = serverSocket.accept();//socket기다린다는 뜻//1. 누군가 드어올 때마다 socket만들어줌
		scanner = new Scanner(System.in);
		
		Receiver receicver = new Receiver();
		receicver.start();
		
		while(true) {
			Sender sender = new Sender();
			Thread t = new Thread(sender);
			System.out.println("Input Server Mesage...");
			String msg = scanner.nextLine();
			if(msg.equals("q")) {
				scanner.close();
				sender.close();
				break;
			}
			System.out.println("server:"+msg);
			sender.setSendMsg(msg);
			t.start();
		}
		System.out.println("Exit ServerChat...");
	}
	
	// Message 
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
					e.printStackTrace();
				}
			}
		}

		class Receiver extends Thread {
			InputStream in;
			DataInputStream din;
			
			public Receiver() throws IOException {
				in = socket.getInputStream();
				din= new DataInputStream(in);
			}
			public void close() throws IOException {
				din.close();
				in.close();
			}
			//메세지 받을 것 대기하고 있어야해//
			@Override
			public void run() {
				while(true) {
					String msg = null;
					try {
						msg = din.readUTF();//여기서 대기//
						System.out.println("client:"+msg);
					} catch (IOException e) {
						System.out.println("Exit Client User...");
						break;
					}
				}
			}
		}
}
