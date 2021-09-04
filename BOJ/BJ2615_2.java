package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2615_2 {
	static final int N = 19;
	static StringTokenizer st;
	static int[][] map;
	static int[] dy = { 1, 0, 1, -1 };// 행인덱스
	static int[] dx = { 0, 1, 1, 1 };// 열인덱스
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// map[i][j] = sc.nextInt();
			}
		}

		Loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					flag = check(i, j);
					if (flag)
						break Loop;
				}
			}
		}

		if (!flag)
			System.out.println(0);

	}

	private static boolean check(int i, int j) {
		int now = map[i][j];

		for (int idx = 0; idx < 4; idx++) {

			int cnt = 1;

			int ni = i + dy[idx];
			int nj = j + dx[idx];

			while (true) {
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == now) {
					cnt++;
					ni += dy[idx];
					nj += dx[idx];
				} else
					break;
			}

			if (cnt == 5) {
				if (i - dy[idx] < 0 || j - dx[idx] < 0 || map[i - dy[idx]][j - dx[idx]] != now) {
					System.out.printf("%d %n%d %d%n", now, i + 1, j + 1);
					return true;
				}
			}
		}
		return false;
	}

}