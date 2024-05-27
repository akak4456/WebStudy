package org.adele.jvm.chapter7;
class ConstClass {
	static {
		System.out.println("ConstClass 초기화!");
	}
	
	public static final String HELLO_WORLD = "hello world";
}
public class NotInitialization_3 {
	public static void main(String[] args) {
		System.out.println(ConstClass.HELLO_WORLD);
	}
}
