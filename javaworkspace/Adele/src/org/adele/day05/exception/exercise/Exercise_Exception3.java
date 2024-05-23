package org.adele.day05.exception.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_Exception3 {
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7,8,9,10};
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("인덱스 입력 : ");
				int idx = sc.nextInt();
				System.out.println("num[" + idx +"]="+num[idx]);
			} catch (InputMismatchException e) {
				System.out.println("잘못된 값을 입력했습니다.");
				sc.next();
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못된 인덱스를 입력했습니다.");
			}
		}
	}
}
