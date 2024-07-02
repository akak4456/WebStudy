package com.kh.jdbc.day04.pstmt.common;

public class Singleton {
	private static Singleton instance;
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
