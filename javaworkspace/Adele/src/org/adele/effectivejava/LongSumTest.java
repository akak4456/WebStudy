package org.adele.effectivejava;

public class LongSumTest {
	public static void main(String[] args) {
		System.out.println("sum is " + sum());
	}
	
	private static long sum() {
		long sum = 0L;
		for(long i=0;i<=Integer.MAX_VALUE;i++) {
			sum += i;
		}
		return sum;
	}
}
