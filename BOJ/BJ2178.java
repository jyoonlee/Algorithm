import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] check;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, res;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M]; // 맵 정보 저장
		check = new boolean[N][M]; // 방문 체크

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		queue = new LinkedList<>();
		queue.offer(new int[] { N - 1, M - 1 });
		check[N - 1][M - 1] = true;
		bfs();

	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int size = queue.size();
			res++; // 이동 횟수 카운팅

			while (size-- > 0) { // 같은 너비
				int[] now = queue.poll();

				if (now[0] == 0 && now[1] == 0) {
					System.out.println(res);
					return;
				}

				for (int idx = 0; idx < 4; idx++) {
					// 너비 탐색을 위해 델타 연산
					int ni = now[0] + dy[idx];
					int nj = now[1] + dx[idx];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == '1' && !check[ni][nj]) {
						check[ni][nj] = true;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}
}
