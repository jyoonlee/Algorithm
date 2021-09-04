package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ4963 {
	static StringTokenizer st;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 델타 탐색
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int row, col;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(in.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			int res = 0;

			if (row == 0 && col == 0) // 종료 조건
				break;

			map = new int[row][col]; // 맵 만들기

			for (int i = 0; i < row; i++) { // 입력
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < col; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1) { // 육지 찾을 경우
						res++; // 섬 추가
						isIsland(i, j); // 이어져있는 육지 찾으러가기
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void isIsland(int i, int j) {

		for (int idx = 0; idx < 8; idx++) { // 팔방 탐색

			int ni = i + dy[idx];
			int nj = j + dx[idx];

			while (ni >= 0 && ni < row && nj >= 0 && nj < col && map[ni][nj] == 1) { // 범위 안이면서 육지면
				map[ni][nj] = 0; // 중복 제거
				isIsland(ni, nj); // 해당 자리부터 탐색 시작 

				ni += dy[idx];
				nj += dx[idx];
			}
		}
	}
}
