import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
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
	private static int N;
	private static int S;
	private static int[] arr = new int[100000];
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = arr[0];
		int startPoint = 0;
		int endPoint = 1;
		int ans = 987654321;
		while(startPoint < N && endPoint <= N) {
			if(sum >= S) {
				ans = Math.min(ans, endPoint - startPoint);
				sum -= arr[startPoint];
				startPoint++;
			} else {
				if(endPoint == N) {
					break;
				}
				sum += arr[endPoint];
				endPoint++;
			} 
		}
		if(ans == 987654321) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
	}
}