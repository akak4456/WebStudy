package org.adele.day09.oop.encapsulation;

import java.util.Scanner;

public class Student {
	// 멤버 필드
	private String name;
	private int firstScore;
	private int secondScore;
	public Student(String name, int firstScore, int secondScore) {
		super();
		this.name = name;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFirstScore() {
		return firstScore;
	}
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}
	public int getSecondScore() {
		return secondScore;
	}
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}
	
	public String toString() {
		return name+"학생의 첫번째 점수는 " +firstScore +"점 두번째 점수는 " + secondScore +"점입니다";
	}
}
