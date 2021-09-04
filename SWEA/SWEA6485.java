package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA6485 {
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			List<int[]> busList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				busList.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			int P = Integer.parseInt(in.readLine());
			int[] cnt = new int[P];

			for (int i = 0; i < P; i++) {
				int now = Integer.parseInt(in.readLine());
				for (int[] value : busList) {
					if (now >= value[0] && now <= value[1])
						cnt[i]++;
				}
			}

			System.out.printf("#%d ", test_case);
			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
	}
}
