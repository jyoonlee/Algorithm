import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
	static boolean[][] waterMap;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Local> water;
	static Local me;

	static class Local {
		int i;
		int j;
		int cnt;

		public Local(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		water = new LinkedList<>();
		map = new char[N][M];
		waterMap = new boolean[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == 'S') // 출발 위치
					me = new Local(i, j, 0);

				if (map[i][j] == '*') { // 물 위치 저장
					water.offer(new Local(i, j, 0));
					waterMap[i][j] = true;
				}
			}
		}

		bfs();
	}

	private static void bfs() {

		// 초기 위치 지정
		boolean[][] check = new boolean[N][M];
		Queue<Local> queue = new LinkedList<>();
		boolean flag = false;
		check[me.i][me.j] = true;
		queue.offer(me);

		while (!queue.isEmpty()) {

			// 물 확산
			int wsize = water.size();

			while (wsize-- > 0) {

				Local now = water.poll();

				for (int i = 0; i < 4; i++) {
					int ni = now.i + dy[i];
					int nj = now.j + dx[i];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 'X' && map[ni][nj] != 'D'
							&& !waterMap[ni][nj]) {
						map[ni][nj] = '*';
						waterMap[ni][nj] = true;
						water.offer(new Local(ni, nj, 0));
					}
				}
			}

			int size = queue.size();

			// 1분이 지났을 때 갈 수 있는 경로 탐색
			while (size-- > 0) {
				Local now = queue.poll();

				if (map[now.i][now.j] == 'D') {
					flag = true;
					System.out.println(now.cnt);
				}

				// 4방 탐색
				for (int i = 0; i < 4; i++) {
					int ni = now.i + dy[i];
					int nj = now.j + dx[i];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != '*' && map[ni][nj] != 'X'
							&& !check[ni][nj]) { // 지나갈 수 있다면

						check[ni][nj] = true;
						queue.offer(new Local(ni, nj, now.cnt + 1));
					}
				}
			}

		}

		if (!flag)
			System.out.println("KAKTUS");

	}
}
