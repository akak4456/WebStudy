package org.adele.day05.dimarray.exercise;

import java.util.Scanner;

public class Exercise_DimArray2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정사각행렬의 사이즈를 입력하시오 > ");
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		int cnt = 1;
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				board[i][j] = cnt;
				cnt++;
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
