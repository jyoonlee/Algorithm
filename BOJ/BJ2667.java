import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2667 {
	static StringTokenizer st;
	static char[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static List<Integer> res;
	static int N, temp = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		res = new ArrayList<>();
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		// 좌표 별로 단지가 발견되면 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					check(i, j);
					res.add(temp);
					temp = 1;
				}
			}
		}

		Collections.sort(res);
		System.out.println(res.size());
		for (int value : res) {
			System.out.println(value);
		}
	}

	private static void check(int i, int j) {
		map[i][j] = 0;

		// 델타 돌리기
		for (int idx = 0; idx < 4; idx++) {
			int ni = i + dy[idx];
			int nj = j + dx[idx];

			if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == '1') {
				map[ni][nj] = 0;
				temp++; // 단지 내 집 개수
				check(ni, nj); // 단지 찾으러 재귀 출발
			}
		}
	}
}
