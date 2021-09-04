package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4789 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] s = in.readLine().toCharArray();

			int sum = 0;
			int need = 0;

			for (int i = 0; i < s.length; i++) {
				if (sum < i) {
					need++;
					sum++;
				}
				sum += s[i] - '0';
			}

			System.out.printf("#%d %d%n", test_case, need);
		}
	}
}
