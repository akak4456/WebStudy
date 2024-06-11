package org.adele.day16.socket.stream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientProgram {
	public static void main(String[] args) {
		String address = "127.0.0.1";
		int port = 8888;
		OutputStream os = null;
		Socket socket = null;
		try {
			socket = new Socket(address, port);
			System.out.println("서버와의 연결에 성공하였습니다.");
			os = socket.getOutputStream();
			os.write(104);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
