package org.adele.day03.control.loop.exercise;

import java.util.Scanner;

public class Exercise_While2 {
	public static void main(String[] args) {
		// While문을 이용하여 -1이 입력될때까지 정수를 입력받고
		// -1이 입력되면 입력한 수의 합을 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		while(num != -1) {
			sum += num;
			System.out.print("정수를 입력하세요 : ");
			num = sc.nextInt();
		}
		System.out.println("총 합 : "+ sum);
	}
}
