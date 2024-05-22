package org.adele.day04.control.loop.exercise;

public class Exercise_ForDouble1 {
	public static void main(String [] args) {
		// *
		// **
		// ***
		// ****
		// *****
		for(int row=1;row<=5;row++) {
			for(int col=1; col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
