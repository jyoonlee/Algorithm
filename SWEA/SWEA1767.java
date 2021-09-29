
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1767 {
	static StringTokenizer st;
	static int[][] map;
	static List<int[]> core;
	static int N, maxCore, minValue;
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			core = new ArrayList<>();
			minValue = Integer.MAX_VALUE; // 전선 길이
			maxCore = 0; // 연결되는 코어 수

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1 && (i != 0 && i != N - 1 && j != 0 && j != N - 1)) // 연결 대상이 될 코어만 리스트에 저장 (이미
																							// 연결X)
						core.add(new int[] { i, j });
				}
			}

			dfs(0, 0, 0); // 시작 인덱스, 연결된 코어 수, 총 길이

			System.out.printf("#%d %d%n", test_case, minValue);
		}
	}

	private static void dfs(int idx, int connected, int value) {

		if (connected + core.size() - idx < maxCore) { // 가지 치기 (현재까지 연결된 코어 수와 앞으로 연결될 코어 수가 max core보다 작다면)
			return;
		}

		// 코어 한바퀴 돌았다면
		if (idx == core.size()) {
			if (maxCore < connected) { // 현재까지 연결된 코어 수와 지금까지 가장 많이 연결됐던 코어 기록 비교
				maxCore = connected;
				minValue = value;
			}

			if (maxCore == connected && minValue > value) { // 연결된 코어 수가 최대값과 같다면 작은 길이 저장
				minValue = value;
			}
			return;

		}

		int[] now = core.get(idx); // 현재 탐색해볼 코어 정보

		for (int i = 0; i < 4; i++) {

			int ni = now[0];
			int nj = now[1];

			int cnt = 0;
			boolean flag = false;

			while (true) {

				ni += dy[i];
				nj += dx[i];

				if (ni < 0 || ni >= N || nj < 0 || nj >= N) { // 연결 가능
					flag = true;
					break;
				}

				if (map[ni][nj] == 1) // 다른 전선에 가로 막힘(연결 불가능)
					break;

				cnt++; // 길이 증가
			}

			/*
			 * 현재 코어를 포함하지 않고 탐색 코어가 연결될 수 없거나, 현재 코어를 포함했을 때 코어 최대값을 못 뽑을 수 있음
			 */
			dfs(idx + 1, connected, value);

			if (flag) { // 만약 연결 가능하다면
				int ti = now[0];
				int tj = now[1];

				// 맵에 전선 설치
				for (int j = 0; j < cnt; j++) {
					ti += dy[i];
					tj += dx[i];

					map[ti][tj] = 1;
				}

				dfs(idx + 1, connected + 1, value + cnt); // 다음 코어 탐색

				// 탐색이 끝난 후에는 맵 원상 복구
				ti = now[0];
				tj = now[1];

				for (int j = 0; j < cnt; j++) { 
					ti += dy[i];
					tj += dx[i];

					map[ti][tj] = 0;
				}
			}
		}
	}
}
