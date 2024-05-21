package org.adele.day02.operator;

public class Assignment_Logical1 {
	public static void main(String [] args) {
		int a = 50;
		int b = 30;
		boolean result1 = a!=b && a<b;// a!=b 는 true a<b는 false 이므로 false
		System.out.println("결과값1 : "+result1);
		boolean result2 = a<b || a==b;// a<b 는 false a==b 는 false 이므로 false
		System.out.println("결과값2 : "+result2);
		boolean result3 = a>b && a != b;// a>b 는 true a != b 는 true 이므로 true
		System.out.println("결과값3 : "+result3);
		boolean result4 = a>b || a==b;// a>b 는 true a==b 는 false 이므로 true
		System.out.println("결과값4 : "+result4);
	}
}
