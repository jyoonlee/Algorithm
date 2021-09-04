package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA1289 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int res = 0;
			String s = in.readLine();
			
			if (s.startsWith("1"))
				res++;

			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					res++;
				}
			}
			System.out.printf("#%d %d%n", test_case + 1, res);
		}
	}
}
