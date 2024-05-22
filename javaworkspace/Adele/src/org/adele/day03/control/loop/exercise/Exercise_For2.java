package org.adele.day03.control.loop.exercise;

public class Exercise_For2 {
	public static void main(String[] args) {
		// 1부터 10까지의 덧셈을 표시하고 합도 구하시오.
		// 1+2+3+4+5+6+7+8+9+10=55
//		int sum = 0;
//		for(int i=1;i<=10;i++) {
//			if(i < 10) {
//				System.out.print("1부터  "+i+"까지 더하라 ");
//			} else {
//				System.out.print("1부터 "+i+"까지 더하라 ");
//			}
//			sum += i;
//			System.out.print("sum = ");
//			for(int j=1;j<=i;j++) {
//				System.out.print(j);
//				if(j < i) {
//					System.out.print("+");
//				}
//			}
//			System.out.println(" = "+sum);
//		}
		
		int sum = 0;
		for(int i=1; i<= 10; i++) {
			sum += i;
			System.out.print(i);
			if(i < 10) {
				System.out.print("+");
			} else {
				System.out.print("="+sum);
			}
		}
	}
}
