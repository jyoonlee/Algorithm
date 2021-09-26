import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17836 공주님을 구해라!

public class BJ17836 {
	static StringTokenizer st;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, T;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] check = new boolean[N][M][2]; // 검을 들고 방문했을 때와 아닐 떄

		// 첫 방문 체크 
		queue.add(new int[] { 0, 0, 0, 0 });
		check[0][0][0] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			// 종료 조건 1. 끝까지 도착했을 때 
			if (now[0] == N - 1 && now[1] == M - 1) {
				System.out.println(now[3]);
				return;
			} 
			// 종료 조건 2. 제한 시간이 지났을 때 
			else if (now[3] > T) {
				System.out.println("Fail");
				return;
			}

			// 4방 탐색
			for (int i = 0; i < 4; i++) {

				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {

					// 지나갈 수 있는 경우 
					if (map[ni][nj] == 0) {

						if (!check[ni][nj][0] && now[2] == 0) { // 검을 들었을 때 
							check[ni][nj][0] = true;

							queue.add(new int[] { ni, nj, 0, now[3] + 1 });
						}

						if (!check[ni][nj][1] && now[2] == 1) { // 들지 않았을 때
							check[ni][nj][1] = true;
							queue.add(new int[] { ni, nj, 1, now[3] + 1 });
						}
					}

					// 벽을 마주쳤으나 검을 들고 있을 때 
					else if (map[ni][nj] == 1 && !check[ni][nj][1] && now[2] == 1) {
						check[ni][nj][1] = true;
						queue.add(new int[] { ni, nj, 1, now[3] + 1 });
					}

					// 검을 획득 !
					else if (map[ni][nj] == 2) {

						if (!check[ni][nj][0] && !check[ni][nj][1]) {
							check[ni][nj][0] = true;
							check[ni][nj][1] = true;

							queue.add(new int[] { ni, nj, 1, now[3] + 1 });
						}
					}
				}
			}
		}
		
		// 종료 조건 3. 끝까지 도달할 수 없을 때
		System.out.println("Fail");
	}
}