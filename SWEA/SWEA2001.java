package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA2001 {
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int res = Integer.MIN_VALUE;

			map = new int[N][N];

			// 파리 맵 입력 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int j = 0;
				while (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}

			// 탐색
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					// 파리채 때리기
					for (int y = i; y < i + M; y++) {
						for (int x = j; x < j + M; x++) {
							sum += map[y][x];
						}
					}
					// max 값 비교
					res = Integer.max(res, sum);
				}
			}

			System.out.printf("#%d %d%n", test_case, res);
		}

	}
}
