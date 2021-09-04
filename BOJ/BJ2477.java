package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2477 {
	static StringTokenizer st;
	static int K, max1, max2, idx1, idx2;
	static final int N = 6;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(in.readLine());
		list = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			// 가로 선 중 최대 값 구하기
			if (direction >= 3 && max1 < value) {
				max1 = value;
				idx1 = i;
			}

			// 세로 선 중 최대 값 구하기
			if (direction <= 2 && max2 < value) {
				max2 = value;
				idx2 = i;
			}

			list[i] = value; // 6개의 변
		}

		delete(list);

		int res = 1;
		for (int i = 0; i < N; i++) {
			if (list[i] != 0) {
				res *= list[i];
			}
		}

		System.out.println((max1 * max2 - res) * K);

	}

	private static void delete(int[] list) {
		// 정상적인 가로 세로와 인접한 선분 다 지우기
		int temp1 = idx1 - 1 < 0 ? N - 1 : idx1 - 1;
		int temp2 = idx2 - 1 < 0 ? N - 1 : idx2 - 1;

		list[temp1] = 0;
		list[temp2] = 0;
		list[(idx1 + 1) % N] = 0;
		list[(idx2 + 1) % N] = 0;
		list[idx1] = 0;
		list[idx2] = 0;
		
		// 남는 것은 오목한 선분 두개
	}
}