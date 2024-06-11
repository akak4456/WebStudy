package org.adele.day16.socket.basic;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		String address = "127.0.0.1";
		int port = 8888;
		try {
			Socket socket = new Socket(address, port);
			System.out.println("서버와 연결되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
