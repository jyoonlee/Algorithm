import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
	static StringTokenizer st;
	static int N, M, res = -1;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(res);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] check = new boolean[N][M][2]; // 벽 부시고 탐색하는 중인지 아닌 지 판별 
		check[0][0][0] = true;
		check[0][0][1] = true;
		queue.offer(new int[] { 0, 0, 0, 1 });

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (now[0] == N - 1 && now[1] == M - 1) {
				res = now[3];
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {

					// 일반 길을 지나갈 때 
					if (map[ni][nj] == 0) {
						
						// 벽을 부순 상태로 지나가는 것과
						if (!check[ni][nj][1] && now[2] == 1) {
							check[ni][nj][1] = true;
							queue.offer(new int[] { ni, nj, now[2], now[3] + 1 });
						}
						
						// 길로만 다녀서 왔던 경우를 나눠준다
						else if (!check[ni][nj][0] && now[2] == 0) {
							check[ni][nj][00] = true;
							queue.offer(new int[] { ni, nj, now[2], now[3] + 1 });
						}

					} else {
						// 벽 만나면 부신다. 
						if (now[2] == 0) {
							check[ni][nj][1] = true;
							queue.offer(new int[] { ni, nj, now[2] + 1, now[3] + 1 });
						}
					}
				}
			}
		}
	}

}
