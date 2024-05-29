package org.adele.day09.oop.inheritance.point;

public class ColorPoint extends Point {
	private String color;
	public ColorPoint() {
		super();
	}
	
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void showColorPoint() {
		super.showPoint();
		System.out.println(this.color + "색의 점입니다.");
	}
}
