package org.adele.day16.socket.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 9999;
		InputStream is = null;
		DataInputStream dis = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("연결을 기다리고 있습니다..");
		} catch (IOException e) {
			e.printStackTrace();
		}
		whileLoop: while (true) {
			try {
				socket = serverSocket.accept();
				System.out.println("연결이 완료되었습니다.");
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				String recvMsg = dis.readUTF();
				String[] tokens = recvMsg.split(" ");
				int a = Integer.parseInt(tokens[0]);
				char ch = tokens[1].charAt(0);
				int b = Integer.parseInt(tokens[2]);
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				int result = 0;
				switch (ch) {
				case '+':
					result = a + b;
					break;
				case '-':
					result = a - b;
					break;
				case '*':
					result = a * b;
					break;
				case '/':
					result = a / b;
					break;
				default:
					break whileLoop;
				}
				dos.writeUTF(result + "");
				dos.flush();
				System.out.println(recvMsg);

				is.close();
				dis.close();
				os.close();
				dos.close();
				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
