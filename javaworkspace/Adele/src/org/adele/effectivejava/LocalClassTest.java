package org.adele.effectivejava;

public class LocalClassTest {
	public static void main(String [] args) {
		class LocalClass {
			public int t;
		}
		LocalClass l = new LocalClass();
		l.t = 50;
		System.out.println("l.t = " + l.t);
	}
}
