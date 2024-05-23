package org.adele.day05.dimarray.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_DimArray8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = -1;
		while(row == -1) {
			System.out.print("가로행의 개수를 입력하세요(1~10)");
			row = sc.nextInt();
			if(row < 1 || row > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				row = -1;
			}
		}
		int col = -1;
		while(col == -1) {
			System.out.print("세로열의 개수를 입력하세요(1~10)");
			col = sc.nextInt();
			if(col < 1 || col > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				col = -1;
			}
		}
		
		char[][] chBoard = new char[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				Random random = new Random();
				chBoard[i][j] = (char)(97 + random.nextInt(26));
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(chBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
