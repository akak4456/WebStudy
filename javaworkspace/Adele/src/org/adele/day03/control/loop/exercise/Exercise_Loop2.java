package org.adele.day03.control.loop.exercise;

import java.util.Scanner;

public class Exercise_Loop2 {
	public static void main(String[] args) {
		// 1번
		// 1부터 사용자에게 입력 받은 수까지 중에서
		// 1) 2와 3의 배수를 모두 출력하고
		// 2) 2와 3의 공배수의 개수를 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int number = sc.nextInt();
		int cnt = 0;
		for(int i=1;i<=number;i++) {
			if(i%2 == 0 && i%3 == 0) {
				cnt++;
				System.out.println(i + "는 2의 배수 이면서 3의배수");
			}
			else if(i%2 == 0) {
				System.out.println(i + "는 2의 배수");
			}
			else if(i%3 == 0) {
				System.out.println(i + "는 3의 배수");
			}
		}
		System.out.println("2와 3의 공배수 개수 : " + cnt);

		// 2번
		/*
		 * 다음과 같은 실행 예제를 구현하세요.
		 *
		 * ex. 정수 입력 : 3
		 *
		 **
		 ***
		 **
		 *
		 */
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=number - 1;i>=0;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 3번
		/*
		 * 다음과 같은 실행 예제를 구현하세요.
		 *
		 * ex. 정수 입력 : 4
		 *
		 ***
		 *****
		 *******
		 */
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=2*(i - 1) + 1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 4번
		/*
		 * 다음과 같은 실행 예제를 구현하세요.
		 *
		 * ex. 정수 입력 : 5
		 *****
		 *   *
		 *   *
		 *   *
		 *****
		 */
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		for(int i=1;i<=number;i++) {
			System.out.print("*");
			for(int j=1;j<=number - 2;j++) {
				if(i==1 || i == number) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("*");
		}

		// 5번
		// 사용자로부터 입력 받은 하나의 값이 소수인지 판별하는 프로그램을 구현하세요.
		// 단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		if(number < 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			boolean isPrime = true;
			for(int i=2;i<=number-1;i++) {
				if(number % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println("소수입니다.");
			} else {
				System.out.println("소수가 아닙니다.");
			}
		}

		// 6번
		// 위 문제와 모든 것이 동일하나, 입력한 수가 2보다 작은 경우
		// “잘못 입력하셨습니다.”를 출력하면서 다시 사용자가 값을 입력하도록 하세요.
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		while(number < 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 : ");
			number = sc.nextInt();
		}
		boolean isPrime = true;
		for(int i=2;i<=number-1;i++) {
			if(number % i == 0) {
				isPrime = false;
				break;
			}
		}
		if(isPrime) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}

		// 7번
		// 2부터 사용자가 입력한 수까지의 소수를 모두 출력하고 소수의 개수를 출력하세요.
		// 단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
		System.out.print("정수를 입력하세요 : ");
		number = sc.nextInt();
		while(number < 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 : ");
			number = sc.nextInt();
		}
		int primeCnt = 0;
		for(int targetNumber = 2; targetNumber <= number; targetNumber++) {
			isPrime = true;
			for(int i=2;i<=targetNumber-1;i++) {
				if(targetNumber % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeCnt++;
				System.out.print(targetNumber + " ");
			}
		}
		System.out.println();
		System.out.println("소수 개수: "+primeCnt);
	}
}
