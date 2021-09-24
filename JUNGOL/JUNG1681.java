import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNG1681 {
	static StringTokenizer st;
	static int N, res = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());
		map = new int[N][N];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 탐색 시작
		dfs(0, 0, 0, 1);
		System.out.println(res);
	}

	private static void dfs(int now, int cnt, int value, int flag) {

		// 가지치기 
		if (value >= res)
			return;

		// 기저조건
		if (cnt == N - 1) {
			if (map[now][0] != 0) { // 회사로 다시 갈 수 없다면 안된다
				value += map[now][0];
				res = Math.min(value, res);
			}
			return;
		}

		// 배달 실행
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0 && map[now][i] != 0)
				dfs(i, cnt + 1, value + map[now][i], flag | 1 << i);
		}
	}
}
