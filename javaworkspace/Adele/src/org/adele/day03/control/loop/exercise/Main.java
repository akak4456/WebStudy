package org.adele.day03.control.loop.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 백준 2614번 청개구리 문제
 * 벼가 심어진 지점의 개수를 N이라 하자
 * X1 = 1x+1의 개수 다시 말해 1번째 칸에 시작하고 1칸씩 뛰는 개구리의 수
 * X2 = 2x+1의 개수 다시 말해 1번째 칸에 시작하고 2칸씩 뛰는 개구리의 수
 * X3 = 2x+2의 개수 다시 말해 2번째 칸에 시작하고 2칸씩 뛰는 개구리의 수
 * ...
 * X21 = 6x+6의 개수 다시 말해 6번째 칸에 시작하고 6칸씩 뛰는 개구리의 수
 * 라 하자.
 * 1) 만약 N >= 21 이라면 미지수의 개수보다 방정식의 개수가 많으므로 가우스 소거법으로 충분히 구할 수 있다.
 * 2) 만약 N < 21 이라면 예컨대 입력이 다음과 같이 주어진다면
 * 8
 * 3 2 3 2 3 1 4 2
 * X1, X2, ... X13 까지는 임의의 숫자로 정해야만 한다.
 * 일단 X1을 정해보자
 * 여기에서 X1은 0~100 까지 가능함을 알 수 있다.
 * 그리고 X2를 정해보자
 * X1 을 로 지정해보자
 * 그렇다면
 * 3 2 3 2 3 1 4 2
 * 은
 * 2 1 2 1 2 0 3 1
 * 이 된다. 이 모든 합을 S라 해보자
 * 그렇다면
 * (N/2 * X2) + (N/2 * X3) + (N/3 * X4) + ... (N/6 * X21) = S
 * 이다.
 * 근데 
 * (N/2 * X2) + (N/2 * X3) + (N/3 * X4) + ... (N/6 * X21) < (N/2) * (X2 + X3 + X4 + ... + X21)
 * 이다.
 * 다시말해
 * S < (N/2) * (X2 + X3 + X4 + ... + X21)
 * 이다. 이는
 * (2S / N) < (X2 + X3 + X4 + ... + X21)
 * 을 의미한다.
 * 여기에서 (X2 + X3 + X4 + ... + X21) <= 100 이므로
 * 만약에 X1을 정할때 2S/N >= 100 이면 이제 이 부분은 더이상 살펴볼 필요가 없다는 것을 알 수 있다.
 * 마찬가지로 X1, X2를 정할 때 2S/N >= 100 이면 이 부분은 더이상 살펴볼 필요가 없다는 것을 알 수 있다.
 * 마찬가지로 X1, X2, X3 를 정할 때 3S/N >= 100 이면 이 부분은 더이상 살펴볼 필요가 없다는 것을 알 수 있다.
 * 이를 반복하면 아마도 백트래킹이 될듯?
 */
class Pair<T1, T2> {
	private T1 first;
	private T2 second;
	Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	public T1 getFirst() {
		return first;
	}
	public T2 getSecond() {
		return second;
	}
}
public class Main {
	/*
	 * X_number 와 같이 표시하도록 한다.
	 * 예를 들어 X1 일때 number=1, X5 일때 number=5 이런식이다.
	 * 
	 * Pair.first: x의 계수, Pair.second: 상수항의 계수
	 * 예를 들어 X1=1x+1 로 표현되므로 Pair.first=1, Pair.second=1
	 */
	private static List<Pair<Integer, Integer>> coefficient = List.of(
				new Pair(0,0), // 계산 편의를 위해 넣은 의미없는 값
				new Pair(1,1),
				new Pair(2,1), new Pair(2,2),
				new Pair(3,1), new Pair(3,2), new Pair(3,3),
				new Pair(4,1), new Pair(4,2), new Pair(4,3), new Pair(4,4),
				new Pair(5,1), new Pair(5,2), new Pair(5,3), new Pair(5,4), new Pair(5,5),
				new Pair(6,1), new Pair(6,2), new Pair(6,3), new Pair(6,4), new Pair(6,5), new Pair(6,6)
			);
	private static int N;
	private static int M[][] = new int[200 + 1][21 + 1];
	private static int B[] = new int[200 + 1];
	private static int minCnt = 987654321;
	private static ArrayList<Integer> minSol = new ArrayList<>();
	private static double[] gaussianElimination(int n) {
        double[][] A = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	// n이 5면 21,20,19,18,17 이다.
                A[i][j] = M[i + 1][21 - n + 1 + j];
            }
            A[i][n] = B[i + 1];
        }

        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = k;
                }
            }
            double[] temp = A[i];
            A[i] = A[maxRow];
            A[maxRow] = temp;
            
            for (int k = i + 1; k < n; k++) {
                double c = -A[k][i] / A[i][i];
                for (int j = i; j <= n; j++) {
                    if (i == j) {
                        A[k][j] = 0;
                    } else {
                        A[k][j] += c * A[i][j];
                    }
                }
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = A[i][n] / A[i][i];
            for (int k = i - 1; k >= 0; k--) {
                A[k][n] -= A[k][i] * x[i];
            }
        }

        return x;
    }
	private static void solve(int curNumber, int remainCnt, ArrayList<Integer> possibleSolution) {
		if(N + curNumber - 1 == 21) {
			// curNumber - 1 까지의 해가 확정이 되었다면
			// 예컨대 N = 8 이고 curNumber = 14 이면
			// curNumber - 1 13 까지의 해가 확정이 되었고
			// N + curNumber - 1 == 21 이 되어서
			// 이때부터는 가우스 소거법 함수를 쓰면 된다.
			double[] sol = gaussianElimination(N);
			int sum = 0;
			for(int i=0;i<sol.length;i++) {
				if(sol[i] < 0) return;
				sum += (int)(sol[i]);
			}
			for(int i=0; i<possibleSolution.size();i++) {
				sum += possibleSolution.get(i);
			}
			if(sum < minCnt) {
				minCnt = sum;
				minSol.clear();
				for(int i=0; i<possibleSolution.size();i++) {
					minSol.add(possibleSolution.get(i));
				}
				for(int i=0;i<sol.length;i++) {
					minSol.add((int)(sol[i]));
				}
			}
			return;
		}
		Pair<Integer, Integer> c = coefficient.get(curNumber);
		int S = 0;
		for(int i=1;i<=N;i++) {
			S += B[i];
		}
		if(S / c.getFirst() >= remainCnt) return;
		int maxCnt = remainCnt;
		ArrayList<Integer> targetRow = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(M[i][curNumber] == 1) {
				maxCnt = Math.min(maxCnt, B[i]);
				targetRow.add(i);
			}
		}
		for(int cnt = maxCnt; cnt >= 0; cnt--) {
			for(int row : targetRow) {
				M[row][curNumber] = 0;
				B[row] -= cnt;
			}
			possibleSolution.add(cnt);
			solve(curNumber + 1, remainCnt - cnt, possibleSolution);
			possibleSolution.remove(possibleSolution.size() - 1);
			for(int row : targetRow) {
				M[row][curNumber] = 1;
				B[row] += cnt;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=21;i++) {
			Pair<Integer, Integer> c = coefficient.get(i);
			if(c.getFirst() + c.getSecond() <= N) {
				// 어찌되었든 뛸 수가 있다면
				int targetRow = c.getSecond();
				while(targetRow <= N) {
					M[targetRow][i] = 1;
					targetRow += c.getFirst();
				}
			}
		}
		if(N >= 21) {
			double[] sol = gaussianElimination(21);
			int sum = 0;
			for(int i=0;i<sol.length;i++) {
				sum += (int)(sol[i]);
				minSol.add((int)(sol[i]));
			}
			minCnt = sum;
		} else {
			solve(1, 100, new ArrayList<>());
		}
		System.out.println(minCnt);
		for(int i=0;i<minSol.size();i++) {
			Pair<Integer, Integer> c = coefficient.get(i+1);
			for(int cnt = 0; cnt < minSol.get(i); cnt++) {
				System.out.println(c.getSecond() + " " + c.getFirst());
			}
		}
	}
}