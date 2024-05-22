package org.adele.day03.control.loop.exercise;

public class Exercise_While1 {
	public static void main(String[] args) {
		// While 문을 이용하여 1 ~ 100 사이의 홀수의 합을 출력하라
		// 1 ~ 100 사이의 홀수의 합 : ?
		int i = 1;
		int sum = 0;
		while(i < 100) {
			sum += i;
			i += 2;
		}
		System.out.println("1 ~ 100 사이의 홀수의 합 : " + sum);
	}
}
