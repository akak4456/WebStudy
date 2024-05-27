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
	private static PriorityQueue<Pair> assignment = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 점수를 가장 많이 받도록
		// 다시 말해 1000일 정도 지났을 때 점수를 가장 많이 받도록
		// 0일 째에는 당연히 점수는 0 즉 최댓값은 0
		// 1일 째에는 모든 과제를 선택할 수 있다.
		// 2일 째에는 d <= 1 인 과제는 선택할 수 없고 이거 제외하고 나머지는 선택 가능하다.
		// 3일 째에는 d <= 2 인 과제는 선택할 수 없고 이거 제외하고 나머지는 선택 가능하다.
		// 근데 day 마다 과제는 1개 선택할 수 있다는 점에 주의해야 한다.
		// 그렇다면 무식하게 풀 때 순열로 만든 다음에 조건에 맞는거만 어찌하면 되겠지
		// 근데 이렇게 하면 당연히 시간초과가 뜰것이다.
		// 그렇다면 그리디인가? 이건 아마 아닐지도...
		// 한번 이렇게 생각해보자. 어차피 과제 데드라인은 정해져있다.
		// 그렇다면 1일째에 dead line 이 1인 것을 선택하는 것과
		// 1일째에 dead line 이 1보다 큰 것을 선택하는 경우로 나누어보자. 즉 dead line 이 1인 것을 포기하는 것이다.
		// dead line 이 1인것을 선택하는 것은 당연히 과제 점수가 제일 높은 것을 선택하는 것이 좋다.
		// dead line 이 1보다 큰것은 어떻게 선택해야 하는가? 근데 이건 사실 아무거나 선택해도 되는거 아니야?
		// 어차피 이 과제들은 아직 데드라인이 남아있단 말이지... 예컨대 데드라인이 2인 것을 선택했다고 해보자. 근데 여기에서
		// 점수가 가장 높은 것을 선택하는 거지. 1일차 기점으로 데드라인이 1 다음으로 급한 것은 2이고 이 날이 지나면 무조건
		// 2에 있는 과목들중 하나를 제외하고 나머지를 포기해야 하기 때문이지...
		// 근데 잠시만 이거 그리디일 가능성도 있겠다.
		// 다시 말해 1일차 중에서 제일 높은 것과 2일차 중에서 제일 높은 것을 비교해서 이중에서 더 높은 것을
		// 선택하는게 낫지 않을까?
		// 이건 그리디다!
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int d,w;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			assignment.add(new Pair(d,w));
		}
		int ans = 0;
		for(int i=1;i<=1000;i++) {
			if(assignment.size() == 0) break;
			Pair top = assignment.poll();
			while(top.first < i) {
				top = assignment.poll();
			}
			ans += top.second;
		}
		System.out.println(ans);
	}
}