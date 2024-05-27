package org.adele.day07.oop;

public class Rectangle {
	public double width;
	public double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
}
