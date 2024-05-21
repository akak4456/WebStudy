import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int A;
	private static int B;
	public static void main(String[] args) throws IOException {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		System.out.println(A+B);
	}
}