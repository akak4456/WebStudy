package org.adele.day02.operator;

public class Exam_Comparison {
	public static void main(String [] args) {
		// 비교 연산자
		// 더이상 =은 이꼬르가 아니다.
		// 이꼬르는 ==다.
		// =은 대입연산자이다!!
		int num1 = 50;
		int num2 = 30;
		boolean result;
		result = (num1 > num2);
		System.out.println("result : "+ result);
		result = (num1 < num2);
		System.out.println("result : "+ result);
		result = (num1 == num2);
		System.out.println("result : "+ result);
		result = (num1 != num2);
		System.out.println("result : "+ result);
	}
}
