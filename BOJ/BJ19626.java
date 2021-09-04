package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ19626 {
	static StringTokenizer st;
	static int N, M, R;
	static int[][] map;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int center, down, top = -1, right, left = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		down = N;
		right = M;
		center = N / 2;
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (R-- > 0) {
			turn();
		}

		for (int[] value : map) {
			for (int n : value) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}

	public static void turn() {
		int idx = 0;
		int ni = 0, nj = 0, i = 0, j = 0, start = 0;
		int now = map[start][start], next = 0;
		int t = top, d = down, l = left, r = right;

		while (start < center) {
			ni = i + dy[idx];
			nj = j + dx[idx];

			if (ni > t && ni < d && nj > l && nj < r) {

				if (ni == start && nj == start) {
					map[ni][nj] = now;
					start++;
					i = start;
					j = start;
					idx = 0;
					now = map[start][start];
					l++;
					r--;
					t++;
					d--;
					continue;
				}

				next = map[ni][nj];
				map[ni][nj] = now;
				now = next;
				i = ni;
				j = nj;

			} else {
				idx = idx + 1;
				if (idx >= 4)
					break;
			}
		}
	}
}
