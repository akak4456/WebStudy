package org.adele.jvm.chapter7;
class SuperClass {
	static {
		System.out.println("상위 클래스 초기화!");
	}
	
	public static int value = 123;
}
class SubClass extends SuperClass {
	static {
		System.out.println("하위 클래스 초기화!");
	}
}
public class NotInitialization_1 {
	public static void main(String[] args) {
		SuperClass[] sca = new SuperClass[10];
	}
}
