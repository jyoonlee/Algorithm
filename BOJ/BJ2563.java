package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2563 {
	static StringTokenizer st;
	static final int M = 100;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] map = new boolean[M][M];
		int N = Integer.parseInt(in.readLine());
		int[][] where = new int[N][2];

		// 입력
		for (int cnt = 0; cnt < N; cnt++) {
			st = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			// 인덱스 주의
			where[cnt][0] = row - 1;
			where[cnt][1] = col - 1;
		}

		// 정사각형이기에 방향 관계 X
		for (int cnt = 0; cnt < N; cnt++) {
			for (int i = where[cnt][0]; i < where[cnt][0] + 10; i++) {
				for (int j = where[cnt][1]; j < where[cnt][1] + 10; j++) {
					map[i][j] = true;
				}
			}
		}

		// 검은 부분 체크
		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j])
					res++;
			}
		}
		System.out.println(res);

	}

}
