package org.adele.day08.oop.score;

import java.util.Scanner;

public class Student {
	int kor;
	int eng;
	int math;
	
	public Student() {
		
	}
	public static int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		System.out.print("선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void inputScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 성적 입력 =====");
		System.out.print("국어 : ");
		kor = sc.nextInt();
		System.out.print("영어 : ");
		eng = sc.nextInt();
		System.out.print("수학 : ");
		math = sc.nextInt();
	}
	
	public void printScore() {
		System.out.println("===== 성적 출력 =====");
		System.out.print("국어 : " + kor);
		System.out.print("영어 : " + eng);
		System.out.print("수학 : " + math);
		System.out.print("총점 : " + (kor + eng + math));
		System.out.print("평균 : " + (kor + eng + math) / 3.0);
	}
	
	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
