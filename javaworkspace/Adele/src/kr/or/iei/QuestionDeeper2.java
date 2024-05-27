package kr.or.iei;

import java.util.Scanner;

public class QuestionDeeper2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < 1 || num > 100) {
			System.out.println("1~100 사이의 정수를 입력하세요!");
		} else {
			if(num == 1) {
				System.out.println("1은 소수가 아닙니다.");
			} else {
				boolean isPrime = true;
				for(int i=2;i<num;i++) {
					if(num % i == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					System.out.println(num+"은(는) 소수입니다.");
				} else {
					System.out.println(num+"은(는) 소수가 아닙니다.");
				}
			}
		}
	}
}
