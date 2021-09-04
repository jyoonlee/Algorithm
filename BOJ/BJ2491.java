package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2491 {
	static StringTokenizer st;
	static int N;
	static int plus = 1, minus = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		String[] list = in.readLine().split(" ");

		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			int a = Integer.parseInt(list[i]);
			int b = Integer.parseInt(list[i + 1]);

			if (a <= b)
				cnt++;
			else
				cnt = 1;
			plus = Integer.max(cnt, plus);

		}

		cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			int a = Integer.parseInt(list[i]);
			int b = Integer.parseInt(list[i + 1]);

			if (a >= b)
				cnt++;
			else
				cnt = 1;
			minus = Integer.max(cnt, minus);

		}

		System.out.println(Integer.max(minus, plus));
	}
}
