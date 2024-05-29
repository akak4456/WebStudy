package org.adele.day09.oop.encapsulation;

public class Circle {
	// 반지름
	// 이름
	private double radius;
	private String name;
	
	
	
	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	// 넓이구하기
	public double getArea() {
		// return을 쓰면 public 옆에
		// 리턴값과 같은 데이터타입을 써야함.
		return 3.14*this.radius*this.radius;
	}
}
