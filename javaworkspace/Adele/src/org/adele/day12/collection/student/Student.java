package org.adele.day12.collection.student;

import java.util.Objects;

public class Student {
	private String name;
	private int firstScore;
	private int secondScore;

	public Student(String name, int firstScore, int secondScore) {
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", firstScore=" + firstScore + ", secondScore=" + secondScore + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstScore, name, secondScore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return firstScore == other.firstScore && Objects.equals(name, other.name) && secondScore == other.secondScore;
	}

}
