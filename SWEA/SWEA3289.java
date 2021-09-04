package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA3289 {
	static int T, N, M, res;
	static int[] parents;
	static StringTokenizer st;

	private static void make() {
		parents = new int[N];

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int i) {

		if (parents[i] == i)
			return i;

		return parents[i] = find(parents[i]);
	}

	private static boolean union(int a, int b) {

		int aParents = find(a);
		int bParents = find(b);

		if (aParents == bParents)
			return false;

		parents[aParents] = bParents;
		return true;
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

			sb.append("#").append(test_case).append(" ");

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());

				int now = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				switch (now) {
				case 0:
					union(a, b);
					break;
				case 1:
					if (find(a) == find(b))
						sb.append("1");
					else
						sb.append("0");

					break;

				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}