package org.adele.day04.array;

public class Exam_Array {
	public static void main(String[] args) {
		int num; // 변수의 선언
		num = 1; // 변수의 초기화
		
		int [] nums;// 배열의 선언
		nums = new int[10];// 배열의 생성(할당)
		nums[0] = 1;// 배열의 초기화
		
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}
}
