package org.adele.day01.printbasic;

import java.util.Scanner;

public class Exam_PrintSample {
	public static void main(String [] args) {
		System.out.print("지금까지는 쓰던 출력 명령어");
		System.out.println();
		System.out.println("지금까지와는 다른 출력 명령어");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("하나의 수 입력 : ");
		int num = sc.nextInt();
		
		// prinf() 메소드
		System.out.printf("정수 출력 : %d", num);
	}
}
