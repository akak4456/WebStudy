package org.adele.day02.control.condition.exercise;

import java.util.Scanner;

public class Exercise_If3 {
	public static void main(String[] args) {
		// 점수를 입력받아 등급을 알려주는 프로그램을 작성해주세요
		// 점수를 입력해주세요 : 92
		// 학점은 A입니다.
		// 단, 점수는 0 ~ 100 사이의 수를 입력하도록 함.
		// 점수를 입력해주세요 : 102
		// 0 ~ 100 사이의 수를 입력해주세요
		// 커트라인 ( 90 ~ 100 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D 그 외 F)
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		if(score < 0 || score > 100) {
			System.out.println("0 ~ 100 사이의 수를 입력해주세요.");
		} else {
			String scoreResult = "";
			if(score >= 90) {
				scoreResult = "A";
			} else if(score >= 80) {
				scoreResult = "B";
			} else if(score >= 70) {
				scoreResult = "C";
			} else if(score >= 60) {
				scoreResult = "D";
			} else {
				scoreResult = "F";
			}
			System.out.println("학점은 "+scoreResult+"입니다.");
		}
	}
}
