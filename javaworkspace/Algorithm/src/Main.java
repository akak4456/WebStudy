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
class PossibleAnswer {
	long attr;
	long firstTarget;
	long secondTarget;
	long thirdTarget;
	
	public PossibleAnswer(long attr, long firstTarget, long secondTarget, long thirdTarget) {
		this.attr = attr;
		this.firstTarget = firstTarget;
		this.secondTarget = secondTarget;
		this.thirdTarget = thirdTarget;
	}
}
public class Main {
	private static int N;
	private static long arr[];
	private static ArrayList<PossibleAnswer> possibleAnswer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int negativeLastPoint = -1;
		for(int i=N-1;i >= 0; i--) {
			if(arr[i] <= 0) {
				negativeLastPoint = i;
				break;
			}
		}
		int positiveFirstPoint = -1;
		for(int i=0;i<N;i++) {
			if(arr[i] >= 0) {
				positiveFirstPoint = i;
				break;
			}
		}
		if(negativeLastPoint != -1 && negativeLastPoint - 2 >= 0) {
			// 음수 3개로만 이루어진것
			long attr = Math.abs(arr[negativeLastPoint - 2] + arr[negativeLastPoint - 1] + arr[negativeLastPoint]);
			possibleAnswer.add(new PossibleAnswer(attr, arr[negativeLastPoint - 2], arr[negativeLastPoint - 1], arr[negativeLastPoint]));
		}
		
		if(positiveFirstPoint != -1 && positiveFirstPoint + 2 < N) {
			// 양수 3개로만 이루어진것
			long attr = Math.abs(arr[positiveFirstPoint] + arr[positiveFirstPoint + 1] + arr[positiveFirstPoint + 2]);
			possibleAnswer.add(new PossibleAnswer(attr, arr[positiveFirstPoint], arr[positiveFirstPoint + 1], arr[positiveFirstPoint + 2]));
		}
		if(negativeLastPoint != -1 && positiveFirstPoint != -1) {
			PossibleAnswer p = new PossibleAnswer(Long.MAX_VALUE, 0, 0, 0);
			for(int i=0;i<N-2;i++) {
				int L = i+1;
				int R = N - 1;
				while(L < R) {
					long sum = arr[i] + arr[L] + arr[R];
					if(p.attr > Math.abs(sum)) {
						p.attr = Math.abs(sum);
						p.firstTarget = arr[i];
						p.secondTarget = arr[L];
						p.thirdTarget = arr[R];
					}
					
					if(sum > 0) {
						R--;
					} else {
						L++;
					}
				}
			}
			possibleAnswer.add(p);
		}
		PossibleAnswer target = possibleAnswer.get(0);
		for(int i=1;i<possibleAnswer.size();i++) {
			if(target.attr > possibleAnswer.get(i).attr) {
				target = possibleAnswer.get(i);
			}
		}
		System.out.println(target.firstTarget + " " + target.secondTarget + " " + target.thirdTarget);
	}
}