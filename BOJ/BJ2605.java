package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2605 {
	static StringTokenizer st;
	static int idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> eat = new ArrayList<>();

		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());

		while (idx++ < N) {
			int pick = Integer.parseInt(st.nextToken());
			eat.add(eat.size() - pick, idx);
		}

		for (int student : eat)
			System.out.print(student + " ");
	}
}
