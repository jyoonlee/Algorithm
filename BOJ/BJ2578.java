package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578 {
	static final int N = 5;
	static int[][] bingo = new int[N][N];
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static StringTokenizer st;
	static int win = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 빙고 게임 시작
		int num = 0;
		Loop: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				check(Integer.parseInt(st.nextToken())); // 탐색 시작
				num++;

				if (win == 3) {
					System.out.println(num);
					break Loop;
				}
			}
		}

	}

	private static void check(int n) {
		int[] condition = new int[4];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == n) {
					bingo[i][j] = 0; // 0으로 바꾸기

					Loop: for (int idx = 0; idx < 8; idx++) { // 8방 탐색
						int y = i + dy[idx];
						int x = j + dx[idx];

						while (true) {
							if (y < 0 || y >= N || x < 0 || x >= N || bingo[y][x] != 0) { // 범위 밖이거나 check가 아닌 경우
								continue Loop;
							}

							condition[idx % 4] += 1;

							if (condition[idx % 4] == 4) {
								if (++win == 3)
									return;
							}

							y += dy[idx];
							x += dx[idx];
						}
					}
					return;
				}
			}
		}
	}
}
