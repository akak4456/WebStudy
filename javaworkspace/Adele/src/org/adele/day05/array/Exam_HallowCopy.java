package org.adele.day05.array;

public class Exam_HallowCopy {
	public static void main(String[] args) {
		int [] arrs = new int[4];
		for(int i=0;i<arrs.length;i++) {
			arrs[i] = i+1;
		}
		
		int [] copy = arrs;
		copy[1] = 11;
		for(int i : arrs) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : copy) {
			System.out.print(i + " ");
		}
	}
}
