package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA4012 {
	static int N;
	static int[][] map;
	static StringTokenizer st;
	static int[] A, B;
	static int taste;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			// 인풋 값
			int res = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			// 조합을 위한 준비 
			int[] check = new int[N];
			for (int i = check.length - 1; i > check.length - N / 2 - 1; i--) {
				check[i] = 1;
			}

			// 재료 시너지 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// np를 이용한 조합 
			do {
				// 재료를 담을 배열 
				A = new int[N / 2];
				B = new int[N / 2];
				int idxA = 0;
				int idxB = 0;

				// 재료 분배하기 
				for (int i = 0; i < check.length; i++) {
					if (check[i] == 1)
						A[idxA++] = i;
					else
						B[idxB++] = i;
				}

				// 요리 시키고 차이 구해주기 
				int temp = Math.abs(cook(A) - cook(B));
				res = res > temp ? temp : res;

			} while (NP(check));

			System.out.printf("#%d %d%n", test_case, res);
		}
	}

	// Next Permutation
	private static boolean NP(int[] check) {
		int i = check.length - 1;

		while (i > 0 && check[i - 1] >= check[i]) // 꼭대기 찾기
			i--;

		if (i == 0) // 탈출 조건 
			return false;

		int j = check.length - 1;

		while (check[i - 1] >= check[j]) // i-1보다 바로 큰 수
			j--;

		swap(check, i - 1, j);

		int k = check.length - 1;

		while (i < k) { // 다시 뒤집어주기
			swap(check, i++, k--);
		}

		return true;
	}

	// NP를 위한 swap
	private static void swap(int[] check, int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}

	// 재료 가지고 요리하기
	private static int cook(int[] now) {

		taste = 0;
		for (int i = 0; i < now.length; i++) {
			for (int j = 0; j < now.length; j++) {
				if (i == j)
					continue;
				taste += map[now[i]][now[j]];
			}
		}
		return taste;
	}

}
