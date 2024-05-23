package org.adele.day05.exception.exercise;

public class Exercise_Exception4 {
	public static void main(String[] args) {
		// 문제4
		// 문자열을 정수로 변환할때
		// 발생하는 NumberFormatException을
		// 처리하는 프로그램을 작성하여라.
		try {
			String str = "12345a";
			int i = Integer.parseInt(str);
			System.out.println("변환된 결과 " + i);
		} catch (NumberFormatException e) {
			System.out.println("exception 발생함");
		}
	}
}
