package org.adele.day03.control.loop;

import java.util.Scanner;

public class Exam_Break {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit을 입력하면 종료합니다.");
		while(true) {
			System.out.print(">>");
			String text = scanner.nextLine();
			if(text.equals("exit")) {
				break;
			}
		}
		System.out.println("종료합니다...");
	}
}
