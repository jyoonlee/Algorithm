import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	static StringTokenizer st;
	static int N, M, res;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 벽 세우기
		makeWall(0);
		System.out.println(res);
	}

	private static void bfs() {

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] check = new boolean[N][M];
		int[][] tempMap = new int[N][M]; // 갱신되어야 하기에 임시 맵

		// 2차원 배열 복사
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, tempMap[i], 0, map[i].length);

		// 바이러스 있는 좌표 큐에 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == 2)
					queue.add(new int[] { i, j });
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			// 4방 탐색
			for (int i = 0; i < 4; i++) {

				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				// 바이러스 퍼뜨리기
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !check[ni][nj] && tempMap[ni][nj] == 0) {
					check[ni][nj] = true;
					tempMap[ni][nj] = 2;
					queue.offer(new int[] { ni, nj });
				}
			}
		}

		// 안전한 공간 카운팅
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == 0)
					cnt++;
			}
		}

		// 최솟값 갱신
		res = Integer.max(cnt, res);
	}

	private static void makeWall(int cnt) {

		// 벽을 다 세웠다면?
		if (cnt == 3) {
			bfs(); // 바이러스 퍼뜨리기
			return;
		}

		// dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 빈공간이라면
					map[i][j] = 1; // 벽 세워보고
					makeWall(cnt + 1); // 카운팅
					map[i][j] = 0; // 원래대로
				}
			}
		}
	}
}