package org.adele.practice.socket;

import java.io.*;
import java.net.*;
public class ChattingServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 9090;
		InputStream is = null;
		DataInputStream dis = null;
		BufferedReader in = null;
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트 기다리는 중");
			socket = serverSocket.accept();
			System.out.println("클라이언트 접속 완료");
			is = socket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));
			// 문자 기반의 보조스트림
			// 전달값은 문자기반 스트림이어야 하지만
			// 소켓의 스트림은 바이트기반 스트림이라서
			// 문자기반 스트림으로 변환하는 과정이 필요함
			String recvMsg = in.readLine();
			System.out.println("클라이언트가 보낸 메시지 : " + recvMsg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
