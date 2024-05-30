import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
class Pair implements Comparable<Pair> {
	int first;
	int second;
	
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pair o) {
		if(this.first == o.first) {
			return o.second - this.second;
		}
		return this.first - o.first;
	}
	
}
public class Main {
	private static int[][] board = new int[9][9];
	private static boolean solved = false;
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			String str = sc.nextLine();
			for(int j=0;j<9;j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		solve(0,0);
		printBoard();
	}
	
	public static void printBoard() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void solve(int row, int col) {
		if(row == 9) {
			solved = true;
			return;
		}
		int nextRow = row;
		int nextCol = col + 1;
		if(nextCol == 9) {
			nextCol = 0;
			nextRow++;
		}
		if(solved) {
			return;
		}
		if(board[row][col] != 0) {
			solve(nextRow, nextCol);
			return;
		}
		int bitmask = 0;
		for(int i=0;i<9;i++) {
			// 행 확인
			bitmask = (bitmask | (1 << board[row][i]));
			// 열 확인
			bitmask = (bitmask | (1 << board[i][col]));
		}
		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				bitmask = (bitmask | (1 << board[rowStart + i][colStart+j]));
			}
		}
		
		for(int i=1;i<=9;i++) {
			if((bitmask & (1 << i)) == 0) {
				board[row][col] = i;
				solve(nextRow, nextCol);
				if(solved) {
					return;
				}
				board[row][col] = 0;
			}
		}
	}
	
}