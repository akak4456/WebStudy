package org.adele.day10.oop.interfaceex;

public interface PhoneInterface {	
	public static final int TIME_OUT = 1000;
	// public String name = "ABC";
	
	public abstract void printLogo();
	
	// public void sendCall() {}; 일반 메소드 사용 불가
	
	void sendCall(); // public abstract 생략 가능
	
	default void showLogo() {
		/*
		 * 디폴트 메소드 (기능 추가)
		 * 하위 호환성을 위해 작성하며
		 * 인터페이스의 보완이 가능함.
		 */
		System.out.println("showLogo");
	}
}
