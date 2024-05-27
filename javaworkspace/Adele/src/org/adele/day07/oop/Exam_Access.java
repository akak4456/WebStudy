package org.adele.day07.oop;
class Sample {
	public int a;
	private int b;
	int c;
}

public class Exam_Access {
	public static void main(String[] args) {
		Sample smp = new Sample();
		smp.a = 507;
		// smp.b = 1023; // The field b is not visible
		smp.c=2024;
	}
}
