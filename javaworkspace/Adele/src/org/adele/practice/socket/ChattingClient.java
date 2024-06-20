package org.adele.practice.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChattingClient {
	public static void main(String[] args) {
		Socket socket = null;
		String address = "127.0.0.1";
		int port = 9090;
		Scanner sc = new Scanner(System.in);
		PrintWriter out = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			socket = new Socket(address, port);
			os = socket.getOutputStream();
			// dos = new DataOutputStream(os);
			out = new PrintWriter(os, true);
			System.out.print("서버에 보낼 메시지 : ");
			String sendMsg = sc.nextLine();
			out.println(sendMsg);
			// dos.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				out.close();
				socket.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
