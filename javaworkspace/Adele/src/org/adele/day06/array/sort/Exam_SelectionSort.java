package org.adele.day06.array.sort;

public class Exam_SelectionSort {
	public static void main(String[] args) {
		// 선택정렬이란?
		// 배열을 전부 검색하여 최소값을 고르고 왼쪽부터 채워나가는 정렬
		// 특징 : 데이터의 양이 적을 때 좋은 성능을 보여주는 정렬
		// 데이터 양이 많을 때 급격한 성능 저하를 보임.
		// 배열의 n번 인덱스값을 n+1 ~ 마지막 인덱스까지 비교함.
		
		
		int[] arrs = {2,5,4,1,3};
		
		for(int i=0;i<5;i++) {
			int min = i;
			for(int j=i+1;j<5;j++) {
				if(arrs[min] > arrs[j]) {
					min = j;
				}
			}
			int temp = arrs[i];
			arrs[i] = arrs[min];
			arrs[min] = temp;
		}
		for(int arr : arrs) {
			System.out.println(arr);
		}
	}
}
