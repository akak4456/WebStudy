package org.adele.day01.inputsc;

import java.util.Scanner;

public class ExerciseScanner1 {
	// 이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.
	// Kim Seoul 20 65.1 true
	// 이름은 Kim, 도시는 Seoul, 나이는 20살, 체중은 65.1kg, 독신 여부는 true입니다.
	
	public static void main(String [] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String city = sc.next();
		int age = sc.nextInt();
		double weight = sc.nextDouble();
		boolean isSolo = sc.nextBoolean();
		System.out.println("이름은 "+name+ ", 도시는 "+city +", 나이는 "+age+"살, 체중은 "+weight + "kg, 독신여부는 "+isSolo+"입니다.");
		sc.close();
	}
}
