package client;

public class Client {
//ip나 port변경, clientchat 시작하고 chat.를 시작
	public static void main(String[] args) {
		String ip = "70.12.111.130";
		int port = 8888;
		ClientChat chat = null;
		chat = new ClientChat(ip, port);
	}
	
}
