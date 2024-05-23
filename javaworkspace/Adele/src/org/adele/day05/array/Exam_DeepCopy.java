package org.adele.day05.array;

public class Exam_DeepCopy {
	public static void main(String[] args) {
		int [] arrs = {0,1,4,9};
		int [] copy = new int[4];
		for(int i=0; i<arrs.length;i++) {
			copy[i] = arrs[i];
		}
		copy[1] = 11;
		for(int i : copy) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : arrs) {
			System.out.print(i + " ");
		}
	}
}
