package org.adele.day05.dimarray.exercise;

import java.util.Scanner;

public class Exercise_DimArray4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정사각행렬의 사이즈를 입력하시오 > ");
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		int cnt = 1;
		for(int j=0;j<n;j++) {
			if(j%2 == 1) {
				for(int i=n-1;i>=0;i--) {
					board[i][j] = cnt;
					cnt++;
				}
			} else {
				for(int i=0;i<n;i++) {
					board[i][j] = cnt;
					cnt++;
				}
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
