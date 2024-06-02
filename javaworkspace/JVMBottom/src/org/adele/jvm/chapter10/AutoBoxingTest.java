package org.adele.jvm.chapter10;

public class AutoBoxingTest {
	public static void main(String [] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 127;
		Integer d = 127;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g == a+b);
		System.out.println(g.equals(a+b));
	}
}
