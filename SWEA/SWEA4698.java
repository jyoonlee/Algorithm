package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4698 {
	static StringTokenizer st;
	static final int MAX = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		boolean[] prime = new boolean[MAX + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i < Math.sqrt(MAX); i++) {
			for (int j = i * 2; j <= MAX; j += i)
				prime[j] = false;
		}

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int res = 0;

			for (int i = A; i <= B; i++) {
				if (prime[i] && String.valueOf(i).contains(D))
					res++;
			}

			System.out.printf("#%d %d%n", test_case, res);
		}
	}
}
