package org.adele.day03.control.loop;

import java.util.Scanner;

public class Exam_DoWhile {
	public static void main(String [] args) {
		// Do ~ While
		// 문법
		// 초기식;
		// do {
		//	실행문장; 증감식;
		// } while(조건식)
		
		// While문을 이용하여 -1이 입력될때까지
		// 정수를 입력하고
		// -1이 입력되면 입력한 수의 합을 출력하시오.
		
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int num = -1;
		do {
			System.out.print("정수 하나 입력 : ");
			num = scanner.nextInt();
			if(num == -1) break;
			sum += num;
		}while(num != -1);
		
	}
}
