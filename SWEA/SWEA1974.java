package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
	static final int N = 9;
	static int[][] map = new int[N][N];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		Loop: for (int test_case = 1; test_case <= T; test_case++) {

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로
			for (int i = 0; i < N; i++) {
				boolean[] checked = new boolean[N];
				for (int j = 0; j < N; j++)
					checked[map[i][j] - 1] = true;

				for (boolean value : checked) {
					if (!value) {
						System.out.printf("#%d 0%n", test_case);
						continue Loop;
					}
				}
			}

			// 세로
			for (int i = 0; i < N; i++) {
				boolean[] checked = new boolean[N];
				for (int j = 0; j < N; j++)
					checked[map[j][i] - 1] = true;

				for (boolean value : checked) {
					if (!value) {
						System.out.printf("#%d 0%n", test_case);
						continue Loop;
					}
				}
			}

			// 9개씩
			for (int i = 0; i < N - 3; i += 3) {
				for (int j = 0; j < N - 3; j += 3) {
					boolean[] checked = new boolean[N];
					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							checked[map[x][y] - 1] = true;
						}
					}
					for (boolean value : checked) {
						if (!value) {
							System.out.printf("#%d 0%n", test_case);
							continue Loop;
						}
					}
				}
			}
			
			System.out.printf("#%d 1%n", test_case);
		}
	}
}
