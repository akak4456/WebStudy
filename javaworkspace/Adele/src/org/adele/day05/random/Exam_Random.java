package org.adele.day05.random;

import java.util.Random;

public class Exam_Random {
	public static void main(String[] args) {
		Random rand = new Random();
		for(int i=0;i<10;i++) {
			int num = rand.nextInt(10);
			System.out.println(num);
		}
	}
}
