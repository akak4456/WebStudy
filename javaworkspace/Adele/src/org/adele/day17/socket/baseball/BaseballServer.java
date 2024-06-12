package org.adele.day17.socket.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class BaseballServer {
	public static void main(String[] args) {
		// 서버소켓을 생성하였습니다.
		// 클라이언트의 접속을 기다립니다.

		// 클라이언트가 접속했습니다.
		// 1 4 5
		// 서버 준비 완료

		int port = 8888;

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버 시작함");
			Random random = new Random();
			while (true) {
				socket = serverSocket.accept();
				System.out.println("클라이언트 접속함");
				is = socket.getInputStream();
				os = socket.getOutputStream();
				dis = new DataInputStream(is);
				dos = new DataOutputStream(os);
				int[] target = new int[3];

				System.out.print("맞춰야 하는 공: ");
				for (int i = 0; i < 3; i++) {
					while(true) {
						target[i] = random.nextInt(10) + 1;
						boolean isValid = true;
						for(int j=0;j<i;j++) {
							if(target[j] == target[i]) {
								isValid = false;
								break;
							}
						}
						if(isValid) {
							break;
						}
					}
					System.out.print(target[i] + " ");
				}
				System.out.println();
				while (true) {
					try {
						String recvMsg = dis.readUTF();
						System.out.println("클라이언트에게 받은 메시지 " + recvMsg);
						String[] tokens = recvMsg.split(" ");
						int strikeCnt = 0;
						int ballCnt = 0;
						for (int i = 0; i < 3; i++) {
							int token = Integer.parseInt(tokens[i]);
							if(token == target[i]) {
								strikeCnt++;
							}
							for (int j = 0; j < 3; j++) {
								if (token == target[j] && i != j) {
									ballCnt++;
								}
							}
						}
						dos.writeUTF(strikeCnt + "");
						dos.writeUTF(ballCnt + "");
						dos.flush();

						if (strikeCnt == 3) {
							System.out.println("클라이언트가 이김");
							break;
						}
					} catch (IOException e) {
						System.out.println("클라이언트가 게임 도중에 나감");
						break;
					} 
				}
				try {
					is.close();
					dis.close();
					os.close();
					dos.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
