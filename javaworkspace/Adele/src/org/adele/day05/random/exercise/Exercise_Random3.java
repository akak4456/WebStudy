package org.adele.day05.random.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random3 {
	public static void main(String[] args) {
		System.out.println("===== Up & Down Game =====");
		Scanner sc = new Scanner(System.in);
		int successCnt = 0;
		int minTryCnt = 987654321;
		while(true) {
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.println("<<Game Start>>");
				int userNumber = 0;
				Random random = new Random();
				int computerNumber = random.nextInt(99) + 1;
				int tryCnt = 0;
				while(userNumber != computerNumber) {
					System.out.print("Input Number : ");
					userNumber = sc.nextInt();
					tryCnt++;
					System.out.print("==========>");
					if(userNumber > computerNumber ) {
						System.out.println("<<DOWN>>");
					} else if(userNumber < computerNumber) {
						System.out.println("<<UP>>");
					} else {
						successCnt++;
						if(minTryCnt > tryCnt) {
							minTryCnt = tryCnt;
						}
						System.out.println("<<정답>>");
					}
				}
			} else if(num == 2) {
				System.out.println("성공한 횟수 : "+successCnt);
				if(successCnt > 0) {
					System.out.println("최소 시도 횟수 : " + minTryCnt);
				}
			} else if(num == 3) {
				break;
			}
		}
	}
}
