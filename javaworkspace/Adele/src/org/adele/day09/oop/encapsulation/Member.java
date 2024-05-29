package org.adele.day09.oop.encapsulation;

import java.util.Scanner;

public class Member {
	// 멤버변수(필드)
	private String name;
	private char gender;
	private int age;
	private String education;
	private long salary;
	private String job;
	private String property;	// 집1채, 자동채2대 / 500000000
	private String phone;		// 01012342345, '1'
	private String address;
	private boolean divorceYN;	// Yes or No
	private String children;		// 1남 1여, 아들1, 딸1
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isDivorceYN() {
		return divorceYN;
	}

	public void setDivorceYN(boolean divorceYN) {
		this.divorceYN = divorceYN;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public Member() {} // 생성자
	
	// 멤버메소드(메소드)
//	public void registerMember() {}
	public void doHeart() {}
	public void sendMessage() {}
	public void doPromise() {}
}
