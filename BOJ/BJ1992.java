package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1992 {
	static int N;
	static char[][] map;
	static StringBuilder res;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		res = new StringBuilder();
		map = new char[N][N];

		// 입력
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		// 분할정복
		quadTree(N, 0, 0);
		System.out.println(res);
	}

	private static void quadTree(int n, int row, int col) {

		char first = map[row][col];
		boolean flag = true;

		// 지금 분할이 압축 가능한지
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (map[i][j] != first) {
					flag = false;
					break;
				}
			}
		}

		// 압축 가능하면 정답에 추가해준다.
		if (flag) {
			res.append(first);
			return;
		}

		// 아니라면 분할
		res.append("(");
		quadTree(n / 2, row, col);
		quadTree(n / 2, row, n / 2 + col);
		quadTree(n / 2, n / 2 + row, col);
		quadTree(n / 2, n / 2 + row, n / 2 + col);
		res.append(")");
	}
}