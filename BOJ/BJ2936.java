import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2936 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int cheese, time, res;
	static Queue<int[]> queue;
	static boolean[][] check;

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

				if (map[i][j] == 1)
					cheese++;
			}
		}

		queue = new LinkedList<>();
		while (cheese > 0) { // 치즈를 다 녹일 때까지 공기 주입
			queue.offer(new int[] { 0, 0 });
			check = new boolean[N][M];
			check[0][0] = true;
			time++; // 시간 추가
			res = cheese; // 남은 치즈 개수

			bfs();
		}

		System.out.println(time);
		System.out.println(res);
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) { // 4방 탐색
				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				while (ni >= 0 && ni < N && nj >= 0 && nj < M && !check[ni][nj]) {

					check[ni][nj] = true;

					if (map[ni][nj] == 1) { // 치즈를 녹였다면 체크
						map[ni][nj] = 0;
						cheese--;
					} else
						queue.offer(new int[] { ni, nj }); // 한턴에 치즈를 녹이거나 더이상 갈 수 없을 때까지를 위해 추가
				}
			}
		}
	}
}
