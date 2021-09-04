package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA7465 {
	static int T, N, M;
	static int[] parents;
	static StringTokenizer st;

	// 단위로 쪼개기
	private static void make() {
		parents = new int[N];

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	// 찾기
	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	// 합치기
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[aRoot] = bRoot;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			make();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				union(a, b);
			}

			HashSet<Integer> res = new HashSet<>();
			for (int i = 0; i < N; i++) {
				res.add(find(parents[i]));
			}

			sb.append("#").append(test_case).append(" ").append(res.size()).append("\n");
		}
		System.out.println(sb);
	}

}