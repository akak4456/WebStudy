package org.adele.day16.socket.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalClient {
	public static void main(String[] args) {
		Socket socket = null;
		String address = "127.0.0.1";
		int port = 9999;
		OutputStream os = null;
		DataOutputStream dos = null;
		InputStream is = null;
		DataInputStream dis = null;
		while (true) {
			try {
				socket = new Socket(address, port);
				System.out.println("서버와의 연결이 완료되었습니다...");
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				Scanner sc = new Scanner(System.in);
				System.out.print("계산식(빈칸으로 띄어 입력, 예 24 + 42) >> ");
				dos.writeUTF(sc.nextLine());
				dos.flush();
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				String recvMsg = dis.readUTF();
				System.out.println("계산결과 : " + recvMsg);

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
	}
}
