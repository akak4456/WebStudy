package org.adele.day05.exception.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_Exception2 {
	public static void main(String[] args) {
		// 문제2
		// 3개의 정수를 입력받아 합을 구하는 프로그램을 작성하여라
		// 사용자가 정수가 아닌 문자를 입력할 때 발생하는
		// InputMismatchException 예외를 처리하여 다시 입력받도록
		// 정수 3개를 입력하세요.
		// 11 2 3
		// 합은 16
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num1, num2, num3;
			try {
				System.out.println("정수 3개를 입력하세요.");
				num1 = sc.nextInt();
				num2 = sc.nextInt();
				num3 = sc.nextInt();
				System.out.println("합은 " + (num1 + num2 + num3));
			} catch(InputMismatchException e) {
				System.out.println("잘못된 정수를 입력하였습니다.");
				sc.next();
			}
		}
	}
}
