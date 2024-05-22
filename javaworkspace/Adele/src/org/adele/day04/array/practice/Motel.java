package org.adele.day04.array.practice;

import java.util.Scanner;

public class Motel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] isOccupied = new boolean[10];
		while(true) {
			boolean exit = false;
			System.out.println("모텔 관리 프로그램 v1.0");
			System.out.println("1. 입실 \t 2.퇴실 \t 3.방보기 \t 4.종료");
			System.out.print("선택 > ");
			int input = sc.nextInt();
			int roomNo;
			switch(input) {
				case 1:
					//입실
					System.out.println("몇번방에 입실하시겠습니까?");
					roomNo = sc.nextInt();
					if(roomNo < 1 || roomNo > 10) {
						System.out.println("잘못된 방번호 입니다.");
					} else {
						if(isOccupied[roomNo - 1]) {
							System.out.println(roomNo+"번방은 현재 손님이 있습니다");
						} else {
							System.out.println(roomNo+"번방에 입실하셨습니다");
							isOccupied[roomNo - 1] = true;
						}
					}
					break;
				case 2:
					//퇴실
					System.out.println("몇번방에서 퇴실하시겠습니까?");
					roomNo = sc.nextInt();
					if(roomNo < 1 || roomNo > 10) {
						System.out.println("잘못된 방번호 입니다.");
					} else {
						if(isOccupied[roomNo - 1]) {
							System.out.println(roomNo+"번방에서 퇴실하셨습니다");
						} else {
							System.out.println(roomNo+"번방은 현재 빈 방입니다");
							isOccupied[roomNo - 1] = true;
						}
					}
					break;
				case 3:
					//방보기
					for(int i=0;i<10;i++) {
						if(isOccupied[i]) {
							System.out.println((i+1)+"번방에는 현재 손님이 있습니다.");
						} else {
							System.out.println((i+1)+"번방이 현재 비어있습니다.");
						}
					}
					break;
				case 4:
					//종료
					exit = true;
					break;
				default: 
					System.out.println("잘못 선택 하셨습니다.");
			}
			if(exit) break;
		}
		sc.close();
	}
}
