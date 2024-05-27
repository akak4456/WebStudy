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
	private static int[] arr = new int[100000];
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(arr[0] > 0) {
			System.out.println(arr[0] +" " + arr[1]);
		} else if(arr[N-1] < 0) {
			System.out.println(arr[N-2] +" " + arr[N-1]);
		} else {
			int negativePointer = -1;
			int positivePointer = -1;
			int lastNegative = -1;
			int firstPositive = -1;
			for(int i=N-1;i>=0;i--) {
				if(arr[i] < 0) {
					negativePointer = i;
					lastNegative = i;
					break;
				}
			}
			for(int i=0;i<N;i++) {
				if(arr[i] > 0) {
					positivePointer = i;
					firstPositive = i;
					break;
				}
			}
			int target1 = -1;
			int target2 = -1;
			int minVal = Integer.MAX_VALUE;
			while(negativePointer >= 0 && positivePointer < N) {
				if(minVal > Math.abs(arr[negativePointer]+arr[positivePointer])) {
					target1 = arr[negativePointer];
					target2 = arr[positivePointer];
					minVal = Math.abs(arr[negativePointer]+arr[positivePointer]);
				}
				if(negativePointer == 0) {
					positivePointer++;
					continue;
				}
				if(positivePointer == N-1) {
					negativePointer--;
					continue;
				}
				int lValue = Math.abs(arr[negativePointer - 1] + arr[positivePointer]);
				int rValue = Math.abs(arr[negativePointer] + arr[positivePointer + 1]);
				if(lValue == rValue) {
					if(Math.abs(arr[negativePointer-1] - arr[negativePointer]) > Math.abs(arr[positivePointer] - arr[positivePointer + 1])) {
						positivePointer++;
					} else {
						negativePointer--;
					}
				}
				if(lValue > rValue) {
					positivePointer++;
				} else {
					negativePointer--;
				}
			}
			if(lastNegative > 0 && Math.abs(arr[lastNegative-1] + arr[lastNegative]) < Math.abs(target1+target2)) {
				target1 = arr[lastNegative-1];
				target2 = arr[lastNegative];
			}
			if(firstPositive < N-1 && Math.abs(arr[firstPositive+1] + arr[firstPositive]) < Math.abs(target1 + target2)) {
				target1 = arr[firstPositive];
				target2 = arr[firstPositive + 1];
			}
			System.out.println(target1 + " " + target2);
		}
	}
}