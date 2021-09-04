package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ8958 {
	static StringTokenizer st;
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int i = 0; i < T; i++) {
			String s = in.readLine();
			int cnt = 1, sum = 0;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'O') {
					sum += cnt;
					cnt++;
				} else
					cnt = 1;
			}
			System.out.println(sum);
		}
	}
}
