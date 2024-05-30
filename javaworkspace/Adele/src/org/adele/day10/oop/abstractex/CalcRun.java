package org.adele.day10.oop.abstractex;

public class CalcRun {
	public static void main(String[] args) {
		Calculator c = new GoodCalc();
		System.out.println("합 : " + c.add(5, 7));
		System.out.println("차 : " + c.subtract(10, 23));
		int [] a = {5,7,10,23};
		System.out.println("평균 : " + c.average(a));
	}
}
