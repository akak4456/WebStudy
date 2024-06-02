import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
class Point {
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class Main {
	private static int N;
	private static int arr[];
	private static int numberToIdx[];
	private static int score[];
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		score = new int[N];
		numberToIdx = new int[1000000 + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			numberToIdx[arr[i]] = i;
		}
		
		for(int i=0;i<N;i++) {
			if(arr[i] <= 10) {
				for(int j=i+1;j<N;j++) {
					if(arr[j] % arr[i] == 0) {
						
					}
				}
			}
		}
	}
}