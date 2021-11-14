import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS하면서 섬 개수 세기 결합

public class BJ2573 {
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] check;
	static int R, C;
	static int res = 0;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Loop: while (true) {
			cnt = 0;
			check = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!check[i][j] && map[i][j] != 0) { // 한번 녹을때 육지 한번만 방문해야 하니 방문 체크
						cnt++; // 섬이 몇개인가?
						bfs(i, j); 
					}

					if (cnt >= 2) { // 섬이 두개 이상이라면 탈출
						System.out.println(res);
						break Loop;
					}
				}
			}
			res++;

			if (cnt == 0) { // 섬이 없을 경우
				System.out.println(0);
				break;
			}
		}

	}

	public static void bfs(int i, int j) {

		Queue<int[]> queue = new LinkedList<>();
		int[][] result = new int[R][C];
		queue.offer(new int[] { i, j });

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			int water = 0;

			for (int idx = 0; idx < 4; idx++) {

				int ny = now[0] + dy[idx];
				int nx = now[1] + dx[idx];

				if (isPossible(ny, nx)) {
					if (map[ny][nx] == 0) { // 물이라면 개수 세주기
						water++;
					} else {
						queue.offer(new int[] { ny, nx }); // 육지라면 다음 카운팅할 곳 
						check[ny][nx] = true; // 방문 체크
					}
				}
			}

			result[now[0]][now[1]] = water; // 인접한 물이 몇개인지
		}

		// 녹여주는 부분
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				map[y][x] = map[y][x] - result[y][x] <= 0 ? 0 : map[y][x] - result[y][x];

			}
		}
	}

	// 범위 체크
	public static boolean isPossible(int i, int j) {
		if (i >= 0 && i < R && j >= 0 && j < C && !check[i][j])
			return true;

		return false;
	}
}