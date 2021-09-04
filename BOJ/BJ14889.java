package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14889 {
	static StringTokenizer st;
	static int N;
	static int half;
	static int[][] map;
	static int[] team;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		half = N / 2; // 절반 값
		map = new int[N][N];
		team = new int[half];

		// 가중치 행렬
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);
		System.out.println(min);
	}

	// 팀 인원 만큼 조합으로 뽑아주기
	private static void combination(int start, int cnt) {
		if (cnt == half) {

			// 팀 선별하기
			boolean[] divideTeam = new boolean[N];

			// true는 조합으로 뽑은 팀원들
			for (int i = 0; i < half; i++) {
				divideTeam[team[i]] = true;
			}

			int sumA = 0;
			int sumB = 0;

			// 전체 map 탐색하면서 합계 구해주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j && divideTeam[i] == divideTeam[j]) {
						if (divideTeam[i])
							sumA += map[i][j];
						else
							sumB += map[i][j];
					}

				}
			}

			// 값 업데이트
			min = Integer.min(min, Math.abs(sumA - sumB));
			return;
		}

		// 조합
		for (int i = start; i < N; i++) {
			team[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}
}