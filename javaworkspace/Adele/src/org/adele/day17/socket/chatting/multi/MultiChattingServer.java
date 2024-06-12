package org.adele.day17.socket.chatting.multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiChattingServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		final int maxPeopleCount = 5; // 서버는 최대 5(maxPeopleCount)명의 유저를 받는다.
		Socket[] socket = new Socket[maxPeopleCount];
		int port = 9999;
		InputStream[] is = new InputStream[maxPeopleCount];
		OutputStream[] os = new OutputStream[maxPeopleCount];
		DataInputStream[] dis = new DataInputStream[maxPeopleCount];
		DataOutputStream[] dos = new DataOutputStream[maxPeopleCount];
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트들의 연결을 기다리고 있습니다...");
			while(true) {
				Socket targetSocket = serverSocket.accept();
				boolean isEnter = false;
				for(int i=0;i<maxPeopleCount;i++) {
					if(socket[i] == null) {
						socket[i] = targetSocket;
						is[i] = socket[i].getInputStream();
						os[i] = socket[i].getOutputStream();
						dis[i] = new DataInputStream(is[i]);
						dos[i] = new DataOutputStream(os[i]);
						isEnter = true;
						final int myIdx = i;
						System.out.println("user" + myIdx + "가 접속했습니다.");
						dos[myIdx].writeUTF("1 당신은 user" + myIdx+" 입니다.");
						dos[myIdx].flush();
						Thread t = new Thread(() -> {
							while(true) {
								if(socket[myIdx] != null) {
									try {
										String recvMsg = dis[myIdx].readUTF();
										int otherIdx = recvMsg.charAt(0) - '0';
										if(socket[otherIdx] != null) {
											dos[otherIdx].writeUTF(myIdx+ ":"+recvMsg);
											System.out.println("user" + myIdx + "가 user"+otherIdx+"에게 메시지를 전송했습니다.");
											dos[otherIdx].flush();
										} else {
											dos[myIdx].writeUTF("아직 상대방이 접속을 하지 않았습니다.");
											dos[myIdx].flush();
										}
									} catch (IOException e) {
										// TODO Auto-generated catch block
										for(int otherIdx = 0; otherIdx < maxPeopleCount; otherIdx++) {
											if(socket[otherIdx] != null) {
												try {
													dos[otherIdx].writeUTF(myIdx+":가 채팅을 종료했습니다.");
													dos[otherIdx].flush();
												} catch(IOException e2) {
													e2.printStackTrace();
												}
											}
										}
										e.printStackTrace();
										break;
									}
								}
							}
							try {
								is[myIdx].close();
								dis[myIdx].close();
								os[myIdx].close();
								dos[myIdx].close();
								socket[myIdx].close();
								socket[myIdx] = null;
								dos[myIdx] = null;
								os[myIdx] = null;
								dis[myIdx] = null;
								is[myIdx] = null;
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
						t.start();
						break;
					}
				}
				if(!isEnter) {
					OutputStream oStream = null;
					DataOutputStream dOStream = null;
					try {
						System.out.println("서버 한계치 초과함");
						oStream = targetSocket.getOutputStream();
						dOStream = new DataOutputStream(oStream);
						dOStream.writeUTF("0 불행히도 당신은 채팅 서버에 접속하지 못했습니다.");
						dOStream.flush();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							oStream.close();
							dOStream.close();
							targetSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
