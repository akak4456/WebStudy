package org.adele.day05.dimarray.exercise;

import java.util.Scanner;

public class Exercise_DimArray9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정사각행렬의 사이즈를 입력하시오 > ");
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		
		int rowIdx = 0;
		int colIdx = n-1;
		int cnt = 0;
		int direction = 0;//0 왼쪽으로 가, 1: 아래로가, 2: 오른쪽으로 가, 3: 위로 가
		while(cnt < n*n) {
			board[rowIdx][colIdx] = cnt+1;
			cnt++;
			boolean directionSelected = false;
			if(cnt == n*n) break;
			while(!directionSelected) {
				int newRowIdx = rowIdx;
				int newColIdx = colIdx;
				switch(direction) {
					case 0:
						newColIdx--;
						break;
					case 1:
						newRowIdx++;
						break;
					case 2:
						newColIdx++;
						break;
					case 3:
						newRowIdx--;
						break;
				}
				if(newRowIdx < 0 || newRowIdx >= n || newColIdx < 0 || newColIdx >= n || board[newRowIdx][newColIdx] != 0) {
					direction = (direction + 1) % 4;
					newRowIdx = rowIdx;
					newColIdx = colIdx;
				} else {
					rowIdx = newRowIdx;
					colIdx = newColIdx;
					directionSelected = true;
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
