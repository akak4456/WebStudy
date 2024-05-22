package org.adele.day03.control.loop.exercise;

import java.util.Scanner;

public class Exercise_Loop1 {
	public static void main(String[] args) {
		// 1번
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int number = sc.nextInt();

		if (number < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			for (int i = 1; i <= number; i++) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// 2번
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		if (number < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			for (int i = number; i >= 1; i--) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// 3번
		// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		if (number < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			int sum = 0;
			for (int i = number; i >= 1; i--) {
				sum += i;
			}
			System.out.println("총 합 : " + sum);
		}

		// 4번
		// 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		// 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		System.out.print("정수 두 개를 입력하세요 : ");
		number = sc.nextInt();
		int number2 = sc.nextInt();
		if (number < 1 || number2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			if(number > number2) {
				int tmp = number;
				number = number2;
				number2 = tmp;
			}
			for (int i = number; i <= number2; i++) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// 5번
		// 사용자로부터 입력 받은 숫자의 단을 출력하세요.
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();
		for (int i = 2; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}

		// 6번
		// 사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		// 단, 9를 초과하는 숫자가 들어오면 “9 이하의 숫자만 입력해주세요”를 출력하세요.
		System.out.println("단을 입력하세요 : ");
		dan = sc.nextInt();
		if (dan > 9) {
			System.out.println("9 이하의 숫자만 입력해주세요");
		} else {
			for (int j = dan; j <= 9; j++) {
				for (int i = 2; i <= 9; i++) {
					System.out.println(j + " * " + i + " = " + (j * i));
				}
			}
		}
	}
}
