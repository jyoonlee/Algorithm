package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {
	static boolean[] isSelected;
	static int[] list;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N + 1];
		list = new int[M];

		bfs(0);
	}

	private static void bfs(int index) {

		if (index == M) {
			StringBuilder st = new StringBuilder();
			for (int value : list) {
				st.append(value + " ");
			}
			System.out.println(st);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;

			list[index] = i;
			isSelected[i] = true;

			bfs(index + 1);

			isSelected[i] = false;
		}

	}

}
