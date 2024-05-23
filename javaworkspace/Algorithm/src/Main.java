import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
class Pair<T1, T2> {
	T1 first;
	T2 second;
	
	Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
}
public class Main {
	private static String input1, input2;
	private static Stack<Pair<Character, Integer>> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		input1 = br.readLine();
		input2 = br.readLine();
		for(int i=0;i<input1.length();i++) {
			int input2Idx = 0;
			if(!stack.isEmpty()) {
				input2Idx = stack.lastElement().second;
			}
			if(input1.charAt(i) != input2.charAt(input2Idx)) {
				if(input1.charAt(i) != input2.charAt(0)) {
					stack.push(new Pair<Character, Integer>(input1.charAt(i), 0));
				} else {
					input2Idx = 0;
				}
			}
			if(input1.charAt(i) == input2.charAt(input2Idx)) {
				stack.push(new Pair<Character, Integer>(input1.charAt(i), input2Idx + 1));
			}
			while(!stack.isEmpty() && stack.lastElement().second == input2.length()) {
				for(int t=0;t<input2.length();t++) {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.elementAt(i).first);
			}
			System.out.println(sb);
		}
	}
}