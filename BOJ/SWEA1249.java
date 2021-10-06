import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class SWEA1249 {
	static StringTokenizer st;
	static int N, cnt, map[][];
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case < T + 1; test_case++) {

			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];

			// 맵 입력
			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			System.out.printf("#%d %d\n", test_case, bfs());

		}
	}

	private static int bfs() {

		// 우선 순위 정렬 기준 설정
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[2] - o2[2];
			}
		});

		queue.offer(new int[] { 0, 0, 0 }); // 처음 위치 
		boolean[][] check = new boolean[N][N]; // 방문 체크

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (now[0] == N - 1 && now[1] == N - 1) { // 끝 지점 도착 
				return now[2];
			}

			for (int i = 0; i < 4; i++) {

				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				if (isPossible(ni, nj, check)) {

					check[ni][nj] = true;
					queue.offer(new int[] { ni, nj, now[2] + map[ni][nj] }); // 기존 가중치 + 현재 가중치 
				}

			}

		}

		return 0;

	}

	private static boolean isPossible(int i, int j, boolean[][] check) {

		if (i >= 0 && i < N && j >= 0 && j < N && !check[i][j])
			return true;
		else
			return false;
	}
}
