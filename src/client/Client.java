package client;

public class Client {
//ip�� port����, clientchat �����ϰ� chat.�� ����
	public static void main(String[] args) {
		String ip = "70.12.111.130";
		int port = 8888;
		ClientChat chat = null;
		chat = new ClientChat(ip, port);
	}
	
}
