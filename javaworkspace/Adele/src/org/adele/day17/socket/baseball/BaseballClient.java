package org.adele.day17.socket.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseballClient {
	public static void main(String[] args) {
		// 클라이언트 소켓을 생성하였습니다.
		// 게임 준비 완료
		// 숫자 입력(띄어쓰기로 구분) ex 1 2 3
		String address = "127.0.0.1";
		int port = 8888;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			socket = new Socket(address, port);
			System.out.println("게임 준비 완료");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("숫자 입력(띄어쓰기로 구분) ex 1 2 3 > ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
				dos.flush();
				int strikeCnt = Integer.parseInt(dis.readUTF());
				int ballCnt = Integer.parseInt(dis.readUTF());
				System.out.println(strikeCnt + "스트라이크 " + ballCnt + "볼");
				if(strikeCnt == 3) {
					System.out.println("아웃! 게임종료!");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
