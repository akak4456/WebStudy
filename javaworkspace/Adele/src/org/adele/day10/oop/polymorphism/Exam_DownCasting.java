package org.adele.day10.oop.polymorphism;

class Person {
	String name;
	String id;
	
	public Person() {}
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
class Student extends Person {
	String grade;
	String department;
	
	public Student() {
	}
	
	public Student(String grade, String department) {
		this.grade = grade;
		this.department = department;
	}
}
public class Exam_DownCasting {
	public static void main(String[] args) {
		Person p = new Student();
		
		System.out.println(p.name);
		System.out.println(p.id);
		
		if(p instanceof Student) {
			System.out.println(((Student)p).grade);
			System.out.println(((Student)p).department);
		}
	}
}
