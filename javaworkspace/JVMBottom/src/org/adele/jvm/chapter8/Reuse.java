package org.adele.jvm.chapter8;

public class Reuse {
	public static void main(String[] args) {
		{
			byte[] placeholder = new byte[64*1024*1024];
		}
		int a = 2;
		System.gc();
	}
}
