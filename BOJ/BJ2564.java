package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2564 {
	static StringTokenizer st;
	static int[][] map;
	static int N, meY, meX, X, Y, res;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(in.readLine());

		map = new int[Y + 1][X + 1];

		for (int i = 0; i <= Y; i++) {
			for (int j = 0; j <= X; j++) {
				if (i > 0 && i < Y && j > 0 && j < X)
					continue;
				map[i][j] = -1;
			}
		}

		for (int n = 1; n <= N + 1; n++) {
			st = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			switch (i) {
			case 1:
				i = 0;
				break;
			case 2:
				i = Y;
				break;
			case 3:
				i = j;
				j = 0;
				break;
			case 4:
				i = j;
				j = X;
				break;
			}

			map[i][j] = n;

			if (n == N + 1) {
				meY = i;
				meX = j;
			}
		}
		
		for(int[] value : map) {
			System.out.println(Arrays.toString(value));
		}

		find();
		System.out.println(res);

	}

	private static void find() {
		int res1 = 0, res2 = 0;

		for (int n = 1; n <= N; n++) {
			res1 = turnClock(n, 0);
			res2 = turnClock(n, 2);
			res += Integer.min(res1, res2);
		}
	}

	private static int turnClock(int n, int start) {
		int[] dy = { 0, -1, 0, 1 };
		int[] dx = { -1, 0, 1, 0 };

		int[][] tempMap = new int[Y + 1][X + 1];

		for (int y = 0; y < Y + 1; y++) {
			for (int x = 0; x < X + 1; x++) {
				tempMap[y][x] = map[y][x];
			}
		}

		int i = meY;
		int j = meX;
		int idx = start;
		int cnt = 0;

		while (true) {

			if (i + dy[idx] < 0 || i + dy[idx] > Y || j + dx[idx] < 0 || j + dx[idx] > X
					|| tempMap[i + dy[idx]][j + dx[idx]] == 0 || tempMap[i + dy[idx]][j + dx[idx]] == -2) {
				idx = (idx + 1) % 4;
				continue;
			}

			i += dy[idx];
			j += dx[idx];
			tempMap[i][j] = -2;
			cnt++;

			if (map[i][j] == n)
				return cnt;
		}
	}
}
