package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ10157 {
	static int R, C, K;
	static StringTokenizer st;
	static int[][] map;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(in.readLine());

		map = new int[R][C];
		map[0][0] = 1;

		int r = 0;
		int c = 0;
		int idx = 0;
		int i = 2;

		if (R * C >= K) {
			while (i <= K) {
				int ni = r + dy[idx];
				int nj = c + dx[idx];

				if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == 0) {
					map[ni][nj] = i++;
					r = ni;
					c = nj;
				} else
					idx = (idx + 1) % 4;

			}
			System.out.println((r + 1) + " " + (c + 1));
		} else
			System.out.println(0);
	}
}