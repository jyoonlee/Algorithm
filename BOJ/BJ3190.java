import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 - 뱀(골드 5)
// https://www.acmicpc.net/problem/3190

public class BJ3190 {
	static int N, K, L;
	static int[][] map;
	static Queue<String[]> order;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static List<int[]> snake;
	static int time = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		order = new LinkedList<>();
		map = new int[N][N];
		snake = new ArrayList<>();
		snake.add(new int[] { 0, 0 });

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			map[y][x] = 1;
		}

		L = Integer.parseInt(in.readLine());

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			order.offer(new String[] { st.nextToken(), st.nextToken() });
		}

		game();
		System.out.println(time);
	}

	private static void game() {

		int direction = 0;
		int ny = 0;
		int nx = 0;

		while (true) {

			if (!order.isEmpty() && Integer.parseInt(order.peek()[0]) == time) {
				String[] now = order.poll();

				if (now[1].equals("D"))
					direction = (direction + 1) % 4;
				else
					direction = direction - 1 < 0 ? 3 : direction - 1;
			}

			ny += dy[direction];
			nx += dx[direction];
			time++;

			if (isPossible(ny, nx)) {

				if (map[ny][nx] != 1) {
					snake.add(new int[] { ny, nx });
					snake.remove(0);
				} else {
					snake.add(new int[] { ny, nx });
					map[ny][nx] = 0;
				}
			} else
				return;
		}

	}

	private static boolean isPossible(int y, int x) {

		if (y >= 0 && y < N && x >= 0 && x < N) {

			for (int i = 0; i < snake.size(); i++) {

				int[] now = snake.get(i);
				if (y == now[0] && x == now[1])
					return false;
			}

			return true;
		} else
			return false;
	}
}
