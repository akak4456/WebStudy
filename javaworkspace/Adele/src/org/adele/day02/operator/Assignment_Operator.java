package org.adele.day02.operator;

public class Assignment_Operator {
	public static void main(String [] args) {
		int a = 5; // a: 5
		int b = 10; // a: 5, b: 10
		int c = (++a) + b;// a: 6, b: 10, c: 6 + 10 = 16
		int d = c / a; // a: 6, b: 10, c: 16, d: 16/6 = 2
		int e = c % a; // a: 6, b: 10, c: 16, d: 2, e: 16 % 6 = 4
		int f = e++; // a: 6, b: 10, c: 16, d: 2, e: 5, f: 4
		int g = (--b) + (d--); // a: 6, b: 9, c: 16, d: 1, e: 5, f: 4, g: 9 + 2 = 11
		int h = 2;
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		/*
		 * a: 7, b: 9, c: 15, d: 1, e: 6, f: 4, g: 10, h: 2
		 * i = a++ + b / (15 / 4) * (g-- - d) % (++e + h)
		 *   = a++ + b / 3 * (11 - 1) % (++e + h)
		 *   = a++ + b / 3 * 10 % (6 + 2)
		 *   = a++ + 9 / 3 * 10 % 8
		 *   = a++ + 3 * 10 % 8
		 *   = a++ + 30 % 8
		 *   = a++ + 6
		 *   = 6 + 6
		 *   = 12
		 */
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		System.out.println("f : " + f);
		System.out.println("g : " + g);
		System.out.println("h : " + h);
		System.out.println("i : " + i);
	}
}
