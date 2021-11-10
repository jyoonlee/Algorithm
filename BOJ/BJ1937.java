import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DP + DFS 문제 (아이디어 어려움)

public class BJ1937 {
	static StringTokenizer st;
	static int[][] map, dp;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, res;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(dfs(i, j), res);
			}
		}

		System.out.println(res);
	}

	public static int dfs(int y, int x) {

		if (dp[y][x] != 0) // 이미 방문했었다면 다시 방문할 필요가 없음
			return dp[y][x];

		dp[y][x] = 1; // 자기 자신부터 길이 1
		for (int idx = 0; idx < 4; idx++) {

			int ny = y + dy[idx];
			int nx = x + dx[idx];

			if (isPossible(ny, nx)) {
				if (map[y][x] < map[ny][nx]) {
					// 나까지 온게 더 큰지, 다른애에서 한번 더 건너온게 더 큰지 비교
					dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
				}
			}
		}

		return dp[y][x]; // 반환
	}

	// 범위 체크
	public static boolean isPossible(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < N)
			return true;

		return false;
	}
}