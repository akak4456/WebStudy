package org.adele.day17.socket.chatting.multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiChattingClient {
	public static void main(String[] args) {
		String address = "127.0.0.1";
		int port = 9999;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket(address, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			final DataInputStream dis = new DataInputStream(is);
			final DataOutputStream dos = new DataOutputStream(os);
			System.out.println("서버와 연결이 완료되었습니다!");
			String initMsg = dis.readUTF();
			System.out.println(initMsg);
			int cd = initMsg.charAt(0) - '0';
			if(cd == 0) {
				System.out.println("클라이언트 종료");
			} else {
				Thread inputThread = new Thread(() -> {
					while(true) {
						String sendMsg = sc.nextLine();
						try {
							dos.writeUTF(sendMsg);
							dos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
					}
				});
				inputThread.start();
				Thread outputThread = new Thread(() -> {
					while(true) {
						try {
							String recvMsg = dis.readUTF();
							int userIdx = recvMsg.charAt(0) - '0';
							System.out.println("user"+userIdx+":"+recvMsg.substring(2));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
					}
				});
				outputThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
