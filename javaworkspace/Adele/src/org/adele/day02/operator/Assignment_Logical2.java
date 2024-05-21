package org.adele.day02.operator;

public class Assignment_Logical2 {
	public static void main(String [] args) {
		int a = 70;
		int b = 55;
		boolean result1 = a==b || a++<100;//a==b가 false a++<100 은 true 이므로 결과값은 true, a: 71, b: 55
		System.out.println("결과값1 : "+result1);
		boolean result2 = a<b && --b<55;// a<b 가 false --b<55 은 true 이므로 결과값은 false, a: 71, b: 55
		System.out.println("결과값2 : "+ result2);
		boolean result3 = a != b && b-- < a++;// a!=b 가 true b-- < a++ 은 true 이므로 결과값은 true, a: 72, b: 53
		System.out.println("결과값3 : "+result3);
		boolean result4 = a++ != b || b++ >= 85; // a++ != b 는 true b++ >= 85 는 false 이므로 결과값은 true, a: 73, b: 54
		System.out.println("결과값4 : "+result4);
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
	}
}
