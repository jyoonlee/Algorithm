import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 도둑찾기 (파이프 경우의 수)

public class SWEA1953 {
	static StringTokenizer st;
	static int N, M, R, C, L, res, time;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case < T + 1; test_case++) {

			// 결과 값 셋팅
			res = 1;
			time = 0;

			// 입력
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// 탐색
			bfs();
			System.out.printf("#%d %d\n", test_case, res);
		}
	}

	private static void bfs() {

		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { R, C, map[R][C] });
		visited[R][C] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();
			time++; // 시간 소요 

			if (time == L) // 기저 조건
				return;

			// 상 우 하 좌
			while (size-- > 0) {

				int[] now = queue.poll();

				// 4방 탐색
				for (int i = 0; i < 4; i++) {

					// 파이프 종류에 따라 탐색할 수 있는 경우의 수가 달라짐
					if ((now[2] == 2 && (i == 1 || i == 3)) || (now[2] == 3 && (i == 0 || i == 2))
							|| (now[2] == 4 && (i == 2 || i == 3)) || (now[2] == 5 && (i == 0 || i == 3))
							|| (now[2] == 6 && (i == 0 || i == 1)) || (now[2] == 7 && (i == 1 || i == 2)))
						continue;

					int ni = now[0] + dy[i];
					int nj = now[1] + dx[i];

					if (isPossible(ni, nj, visited, now[2], i)) { // 방문 가능한 지 
						res++; // 가능하다면 경우의 수 증가
						visited[ni][nj] = true;
						queue.offer(new int[] { ni, nj, map[ni][nj] });
					}
				}
			}
		}
	}

	private static boolean isPossible(int i, int j, boolean[][] visited, int now, int direction) {

		if (i >= 0 && i < N && j >= 0 && j < M && !visited[i][j] && map[i][j] != 0) { // 범위 안이고, 방문안했고, 파이프가 있다면 

			int temp = map[i][j]; // 탐색할 위치의 파이프 종류 

			// 연결할 수 있는 파이프인가?
			if ((direction == 0 && (temp == 3 || temp == 4 || temp == 7))
					|| (direction == 1 && (temp == 2 || temp == 4 || temp == 5))
					|| (direction == 2 && (temp == 3 || temp == 5 || temp == 6))
					|| (direction == 3 && (temp == 2 || temp == 6 || temp == 7)))
				return false;

			return true; // 할 수 있다면 탐색 후 큐에 추가
		} else
			return false;
	}
}
