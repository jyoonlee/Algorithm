package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
	static int N, L, max, sum;
	static StringTokenizer st;
	static int[] snack;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			snack = new int[N];
			int index = 0;
			st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				snack[index++] = Integer.parseInt(st.nextToken());
			}

			check(0, 0, 0);

			if (max == 0)
				max = -1;

			sb.append("#").append(test_case).append(" ").append(max).append("\n");
			max = 0;
		}
		System.out.println(sb);

	}

	private static void check(int i, int sum, int cnt) {
		if (cnt == 2 || i >= N) {
			if (sum <= L && cnt == 2)
				max = Integer.max(max, sum);

			return;
		}

		check(i + 1, sum + snack[i], cnt + 1);
		check(i + 1, sum, cnt);

	}
}
