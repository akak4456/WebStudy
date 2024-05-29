package org.adele.day09.oop.inheritance.point;

public class Point {
	public int pub;
	int def;
	protected int pro;
	private int pri;
	
	private int x,y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void showPoint() {
		System.out.printf("%d, %d\n", x, y);
	}
}
