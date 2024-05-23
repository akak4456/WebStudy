package org.adele.day05.random.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int winCnt = 0;
		int loseCnt = 0;
		int drawCnt = 0;
		while(true) {
			System.out.println("Baskin Robbins31 Game");
			System.out.println();
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.println("<<Game Start>>");
				int curNum = 0;
				boolean isMyTurn = true;
				while(curNum < 31) {
					if(isMyTurn) {
						System.out.print("Input Number(1~3) ");
						int n = sc.nextInt();
						curNum += n;
					} else {
						Random random = new Random();
						int n = random.nextInt(3) + 1;
						curNum += n;
						System.out.println("<<Computer Turn>>");
					}
					if(curNum < 31) {
						System.out.println(curNum + "!");
					} else {
						if(isMyTurn) {
							loseCnt++;
							System.out.println("당신이 졌습니다.");
						} else {
							winCnt++;
							System.out.println("당신이 이겼습니다.");
						}
					}
					isMyTurn = !isMyTurn;
				}
			} else if(num == 2) {
				System.out.println("<<당신의 전적>>");
				System.out.println("WIN:"+winCnt);
				System.out.println("LOSE:"+loseCnt);
				System.out.println("DRAW:"+drawCnt);
			} else {
				break;
			}
		}
	}
}
