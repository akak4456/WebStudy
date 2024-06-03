package org.adele.effectivejava;

/*
 * -XX:+UseSerialGC
 */
class Large2 {
	private byte[] b;
	public Large2() {
		b = new byte[20 * 1024 * 1024];
	}
}
class Large1 {
	private Large2 large2_1;
	private Large2 large2_2;
	public Large1() {
		large2_1 = new Large2();
		large2_2 = new Large2();
	}
}
public class GCTest {
	public static void main(String[] args) {
		Large1 large1 = new Large1();
		large1 = null;
		System.gc();
	}
}
