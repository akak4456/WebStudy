package org.adele.day06.array.sort;

public class Exam_InsertionSort {
	public static void main(String[] args) {
		// 삽입정렬
		// 정렬 알고리즘 중에 하나, 가장 간단하고 기본이 되는 알고리즘
		// 배열의 N번 인덱스값을 0번에서 n-1번 인덱스까지 비교~! 
		// N은 1부터 시작
		// {2, 5, 4, 1, 3}
		// 5와 2 비교 -> 변경 X
		// {2, 5, 4, 1, 3}
		// 4와 비교 시작
		// 두번째 : 4와 5비교 -> 교환
		//          4와 2비교 -> 교환 X
		// 결과 : {2, 4, 5, 1, 3}
		// 세번째 : 1과 5비교 -> 교환
		//          1과 4비교 -> 교환
		//          1과 2비교 -> 교환
		// 결과 : {1, 2, 4, 5, 3}
		// 네번째 : 3과 5비교 -> 교환
		//          3과 4비교 -> 교환
		//          3과 2비교 -> 교환 X
		
		int[] nums = {2,5,4,1,3};
		for(int i=1;i<nums.length;i++) {
			int key = nums[i];
			int targetIdx;
			for(targetIdx=i-1;targetIdx>=0;targetIdx--) {
				if(key < nums[targetIdx]) {
					nums[targetIdx + 1] = nums[targetIdx];
				} else {
					break;
				}
			}
			nums[targetIdx + 1] = key;
		}
		for(int num : nums) {
			System.out.println(num);
		}
	}
}
