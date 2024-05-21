package org.adele.day03.control.loop.exercise;

import java.util.Scanner;

public class Exercise_For1 {
	public static void main(String[] args) {
		// 정수 하나를 입력받아서 그 수가 1 ~ 9 사이의 수일 때만
		// 그 수의 구구단을 출력하세요.
		// 단, 조건이 맞지 않으면 "1 ~ 9사이의 양수를 입력하여야 합니다" 를
		// 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int dan = sc.nextInt();
		if(dan < 1 || dan > 9) {
			System.out.println("1 ~ 9사이의 양수를 입력하여야 합니다");
		} else {
			for(int i = 1; i<=dan;i++) {
				for(int j=1; j<=dan;j++) {
					System.out.printf("%dx%d=%2d ", j,i,i*j);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
