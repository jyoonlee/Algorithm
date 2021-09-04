package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2805 {
	// 농작물 수확하기
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			int N = Integer.parseInt(in.readLine());
			int center = N / 2;
			int sum = 0;
			
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			for (int i = 0; i < center; i++) {
				for (int j = center - i; j <= center + i; j++) {
					sum += map[i][j];
				}
			}

			for (int i = N / 2; i < N; i++) {
				for (int j = i - center; j < N - i + center; j++) {
					sum += map[i][j];
				}
			}

			System.out.printf("#%d %d%n", test_case + 1, sum);
		}

	}

}
