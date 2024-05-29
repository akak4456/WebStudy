package org.adele.day09.oop.inheritance;

import org.adele.day09.oop.inheritance.point.Point;

class Super {
	public int pub;
	int def;
	protected int pro;
	private int pri;
}
class Sub extends Super {
	void set() {
		super.pub = 24;
		super.def = 5;
		super.pro = 7;
		// super.pri = 1023;
	}
}
class ShapePoint extends Point {
	void set() {
		Point p = new Point();
		p.pub = 24;
		// p.def = 57;
		// p.pro = 10;
		// p.pri = 23;
		super.pro = 23;
		super.pub = 2024;
		// super.def = 10;
		// super.pri = 1023;
	}
}
public class Exam_Protected {

}
