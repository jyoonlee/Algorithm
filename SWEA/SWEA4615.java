package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4615 {
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] map;
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int center = N / 2 - 1;

			int black = 0, white = 0;
			int M = Integer.parseInt(st.nextToken());

			// 중앙 저장
			map[center][center] = 2;
			map[center][center + 1] = 1;
			map[center + 1][center] = 1;
			map[center + 1][center + 1] = 2;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int now = Integer.parseInt(st.nextToken());
				map[y][x] = now;

				set(y, x, now);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						black++;
					else if (map[i][j] == 2)
						white++;
				}
			}

			System.out.printf("#%d %d %d%n", test_case, black, white);
		}
	}

	public static void set(int i, int j, int now) {

		for (int cnt = 0; cnt < 8; cnt++) { // 팔방탐색
			int ni = i + dy[cnt];
			int nj = j + dx[cnt];
			int until = 0;
			boolean flag = false;

			// 바꿀 수 있는 지 카운팅
			while (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] != 0) {
				if (map[ni][nj] == now) {
					flag = true; // 같은 돌 색깔을 만났을 때
					break;
				}
				until++;
				ni += dy[cnt];
				nj += dx[cnt];
			}

			// 바꾸기
			ni = i;
			nj = j;
			if (flag) {
				for (int value = 0; value < until; value++) {
					ni += dy[cnt];
					nj += dx[cnt];
					map[ni][nj] = now;
				}
			}
		}
	}

}
