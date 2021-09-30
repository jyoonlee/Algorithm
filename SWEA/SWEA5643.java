import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 키 순서 (부모, 자식 노드 수 세기)

public class SWEA5643 {
	static StringTokenizer st;
	static int N, M, parents, child;
	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case < T + 1; test_case++) {

			N = Integer.parseInt(in.readLine().trim());
			M = Integer.parseInt(in.readLine().trim());

			map = new boolean[N + 1][N + 1]; // 인접 행렬

			for (int idx = 0; idx < M; idx++) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());

				map[i][j] = true; // from -> to
			}

//			for (List<Integer> res : adjList)
//				System.out.println(res);

			int res = 0;
			for (int i = 1; i <= N; i++) {

				// 부모 찾기
				parents = 0;
				visited = new boolean[N + 1];
				up(i);

				// 자식 찾기
				child = 0;
				visited = new boolean[N + 1];
				down(i);

				// 자신 위치 알 수 있다면?
				if (parents + child == N - 1)
					res++;

			}

			System.out.printf("#%d %d\n", test_case, res);

		}
	}

	private static void up(int now) {

		visited[now] = true;
		for (int i = 1; i <= N; i++) {

			if (!visited[i] && map[now][i]) { // 방문 안했고, 자식이라면
				parents++;
				up(i);
			}
		}
	}

	private static void down(int now) {

		visited[now] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[i][now]) { // 방문 안했고, 부모라면
				child++;
				down(i);
			}
		}
	}

}
