package kr.or.iei;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		int[] nums = new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.print((i+1)+"번째 정수 입력 : ");
			nums[i] = sc.nextInt();
		}
		
		for(int i=0;i<nums.length - 1;i++) {
			for(int j=0; j<(nums.length - 1 - i);j++) {
				if(nums[j + 1] < nums[j]) {
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		System.out.print("정렬된 결과 : ");
		for(int num:nums) {
			System.out.print(num + " ");
		}
		System.out.println("정렬 후 첫번째 수와 마지막수의 합 : " + (nums[0] + nums[4]));
	}
}
