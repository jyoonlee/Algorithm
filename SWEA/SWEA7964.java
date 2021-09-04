package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7964 {
	static int N, D;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			char[] palace = in.readLine().toCharArray();
			int cnt = 0;
			int res = 0;
			for (char value : palace) {

				if (value == '0')
					cnt++;

				if (cnt == D || value == '1') {
					if (cnt == D)
						res++;
					cnt = 0;
				}
			}
			System.out.printf("#%d %d%n", test_case, res);
		}
	}
}
