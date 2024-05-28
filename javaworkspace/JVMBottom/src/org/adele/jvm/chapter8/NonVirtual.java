package org.adele.jvm.chapter8;

public class NonVirtual {
	public static void sayHello() {
		System.out.println("hello world");
	}
	public static void main(String[] args) {
		NonVirtual.sayHello();
	}
}
