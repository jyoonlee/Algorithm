import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS 문제 최장 거리 파악하기 

public class BJ2589 {
	static StringTokenizer st;
	static char[][] map;
	static int R, C;
	static int res = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L')
					bfs(i, j);
			}
		}
		
		System.out.println(res);
	}

	public static void bfs(int i, int j) {

		boolean check[][] = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { i, j, 0 });
		check[i][j] = true;

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			res = Integer.max(res, now[2]);

			for (int idx = 0; idx < 4; idx++) {

				int ny = now[0] + dy[idx];
				int nx = now[1] + dx[idx];

				if (isPossible(ny, nx, check)) {
					check[ny][nx] = true;
					queue.offer(new int[] { ny, nx, now[2] + 1 });
				}

			}

		}
	}

	public static boolean isPossible(int i, int j, boolean[][] check) {
		if (i >= 0 && i < R && j >= 0 && j < C && map[i][j] == 'L' && !check[i][j])
			return true;
		return false;
	}
}