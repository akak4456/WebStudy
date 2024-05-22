package org.adele.day04.control.loop.exercise;

public class Exercise_ForDouble3 {
	public static void main(String[] args) {
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.print(j + " * " + i + " = " + j*i + " ");
			}
			System.out.println();
		}
	}
}
