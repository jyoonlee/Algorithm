import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 - 워셜

public class SWEA1263 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];

			int max = N * N; // 갈 수 있는 거리는 N*N을 넘을 수 없다.

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());

					if (adjMatrix[i][j] == 0) // 0이면 연결이 안되어있으니 최대 값
						adjMatrix[i][j] = max;

					if (i == j)
						adjMatrix[i][j] = 0; // 자기 자신이라면 0으로 초기화
				}
			}

			// 플로이드 - 와샬 알고리즘 
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
					}
				}
			}

			// 행 별로 연산 값 비교 
			int res = max;
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < N; j++)
					temp += adjMatrix[i][j];

				res = Integer.min(res, temp);
			}

			System.out.printf("#%d %d\n", test_case, res);
		}
	}
}
