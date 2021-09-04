package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ10026 {
	static int N;
	static char[][] map;
	static int[] parents;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		int no = 0;
		int yes = 0;
		boolean flag = false;

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		yes = find(flag);
		no = find(!flag);

		System.out.printf("%d %d%n", yes, no);

	}

	private static void make() {
		int num = N * N;
		parents = new int[num];

		for (int i = 0; i < num; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aParents = find(a);
		int bParents = find(b);

		parents[aParents] = bParents;
	}

	private static int find(boolean flag) {

		make();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int now = 0; now < 4; now++) {
					int ni = i + dy[now];
					int nj = j + dx[now];
					if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
						if (map[i][j] == map[ni][nj]
								|| ((map[i][j] == 'R' && map[ni][nj] == 'G' || map[i][j] == 'G' && map[ni][nj] == 'R')
										&& flag)) {

							switch (now) {
							case 0:
								union(idx, idx - N);
								break;
							case 1:
								union(idx, idx + 1);
								break;
							case 2:
								union(idx, idx + N);
								break;
							case 3:
								union(idx, idx - 1);
								break;
							}
						}
					} else
						continue;
				}
				idx++;
			}
		}

		HashSet<Integer> check = new HashSet<>();
		for (int i = 0; i < N * N; i++) {
			check.add(find(i));
		}
		return check.size();
	}
}
