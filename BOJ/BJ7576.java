import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static StringTokenizer st;
	static int N, M, res = -1;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 탐색 시작

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					queue.offer(new int[] { i, j });
			}
		}

		bfs(queue);
		if(!isDone())
			System.out.println(-1);
		else
			System.out.println(res);
	}

	private static void bfs(Queue<int[]> queue) {

		while (!queue.isEmpty()) {
			int size = queue.size();
			res++;

			while (size-- > 0) {
				int[] now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int ni = now[0] + dy[i];
					int nj = now[1] + dx[i];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
						map[ni][nj] = 1;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}

	private static boolean isDone() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}

		return true;
	}
}
