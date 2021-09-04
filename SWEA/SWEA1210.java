package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 사다리 문제
// 거꾸로 타고 가보자

public class SWEA1210 {
	static int N = 100;
	static int[][] map = new int[N][N];
	static int[] deltas = { 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(in.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int j = 0;
				while (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}

			for (int j = 0; j < N; j++) {
				if (map[N - 1][j] != 2)
					continue;

				int res = j;
				Loop: for (int i = N - 2; i >= 0; i--) {
					for (int delta : deltas) {
						if (res + delta < 0 || res + delta >= 100)
							continue;

						if (map[i][res + delta] == 1) {
							res += delta;
							while (map[i - 1][res] != 1) {
								res += delta;
							}
							continue Loop;
						}
					}
				}
				
				System.out.printf("#%d %d%n", num, res);
				break;
			}
		}
	}
}
