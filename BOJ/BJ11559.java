import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 뿌요뿌요 
// BFS, 맵 재배치 
// https://www.acmicpc.net/problem/11559

// Y...YR
// B.RGGY
// R.GGYY
// G.RYGR
// YGYGRR
// YBRYGY
// RRYYGY
// YYRBRB
// YRBGBB
// GBRBGR
// GBRBGR
// GBRBGR
// output : 14

public class BJ11559 {
	static StringTokenizer st;
	static char[][] map = new char[12][6];
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int boom, res;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = in.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		while (true) {
			boom = 0;

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						bfs(i, j, map[i][j]);
					}
				}
			}

			if (boom == 0)
				break;
			else
				res++;

			set();
//			print();
		}

		System.out.println(res);
	}

	private static void bfs(int i, int j, char alpha) {

		Queue<int[]> queue = new LinkedList<>();
		List<int[]> sameOne = new ArrayList<>();
		boolean[][] check = new boolean[12][6];
		check[i][j] = true;

		queue.offer(new int[] { i, j });
		sameOne.add(new int[] { i, j });

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int idx = 0; idx < 4; idx++) {

				int ni = now[0] + dy[idx];
				int nj = now[1] + dx[idx];

				if (isPossible(ni, nj) && !check[ni][nj] && map[ni][nj] == alpha) {
					sameOne.add(new int[] { ni, nj });
					queue.offer(new int[] { ni, nj });
					check[ni][nj] = true;
				}
			}
		}

		if (sameOne.size() >= 4) {
			boom++;

			for (int[] value : sameOne)
				map[value[0]][value[1]] = '.';
		}
	}

	private static void set() {

		for (int j = 0; j < 6; j++) {
			for (int i = 11; i > 0; i--) {
				if (map[i][j] == '.') {
					int checkpoint = -1;
					for (int z = i; z >= 0; z--) {
						if (map[z][j] != '.') {
							checkpoint = z;
							break;
						}
					}

					if (checkpoint != -1) {
						for (int z = i; z > 0; z--) {
							map[z][j] = map[checkpoint][j];
							map[checkpoint][j] = '.';
							checkpoint--;

							if (checkpoint < 0)
								break;
						}
					}
				}
			}
		}
	}

	private static boolean isPossible(int i, int j) {

		if (i >= 0 && i < 12 && j >= 0 && j < 6)
			return true;

		return false;
	}

	private static void print() {
		for (char[] value : map) {
			System.out.println(Arrays.toString(value));
		}
	}

}
