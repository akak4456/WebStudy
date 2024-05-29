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
	}
}