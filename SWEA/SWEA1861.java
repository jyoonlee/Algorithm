package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861 {
	static int N, MAX, start;
	static int map[][]; // N*N 방 숫자를 기록할 곳
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int memo[][]; // 행, 열 위치 기준으로 출발

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			memo = new int[N][N];
			MAX = 0;

			// 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (memo[i][j] == 0) {
						count = go(i, j);

						if (count > MAX) {
							MAX = count;
							start = map[i][j];
						} else if (count == MAX) {
							if (start > map[i][j])
								start = map[i][j];
						}
					}
				}
			}
			System.out.printf("#%d %d %d%n", test_case, start, MAX);
		}
	}

	// r, c 위치에서 출발하여 갈 수 있는 방의 개수
	private static int go(int r, int c) {
		// 4방 모두 탐색해서 경계 벗어나지 않고 정확하게 나보다 1큰 방 만나면 진행
		int nr, nc, res = 0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 경계 확인
				if (map[nr][nc] == map[r][c] + 1) {
					res = go(nr, nc);
					break;
					// 재귀가 리턴되었다? 갈 수 있는 만큼 간 다음 리턴
					// 4방 중에서 현위치 기준으로 +1 하나밖에 없음

				}
			}
		}
		// 여기까지 내려왔다? 위에 리턴의 상황을 만족하지 못했다는 이야기 --> 이동 가능한 방이 없다.
		// 즉, 첫 출발 위치 기준으로 갈 수 있는 끝까지 가본 상태
		return memo[r][c] = res + 1;
		// 현재 카운팅 한 수가 이동 횟수, 방의 수는 +1 해줘야 함
	}

}
