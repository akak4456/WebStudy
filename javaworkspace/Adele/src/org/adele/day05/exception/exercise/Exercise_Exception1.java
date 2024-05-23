package org.adele.day05.exception.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_Exception1 {
	public static void main(String[] args) {
		// 문제1
		// 정수를 0으로 나누는 경우에 "0으로 나눌 수 없습니다!"를
		// 출력하고 다시 입력 받는 프로그램을 작성하여라
		int num1 = 0, num2 = 0;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("첫번째 정수 입력 >");
				num1 = sc.nextInt();
				System.out.print("두번째 정수 >");
				num2 = sc.nextInt();
				result = num1 / num2;
				System.out.println(num1+"을 "+num2+"로 나눈 몫은 "+result+"입니다." );
			} catch(InputMismatchException e) {
				System.out.println("잘못된 값을 입력했습니다.");
				sc.next();
			} catch(ArithmeticException e) {
				System.out.println("0으로 나누었습니다.");
			}
		}
	}
}
