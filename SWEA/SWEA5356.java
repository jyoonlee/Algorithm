package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5356 {
	static int T, N;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			char[][] input = new char[5][15];

			for (int i = 0; i < 5; i++) {
				Arrays.fill(input[i], ' ');
				String s = in.readLine();
				for (int j = 0; j < s.length(); j++) {
					input[i][j] = s.charAt(j);
				}
			}

			String res = "";

			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (input[i][j] != ' ')
						res += input[i][j];
				}
			}

			System.out.printf("#%d %s%n", test_case, res);
		}
	}
}