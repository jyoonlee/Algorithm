package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2304 {
	static StringTokenizer st;
	static int N, center, max;
	static List<int[]> container;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		container = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int left = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			container.add(new int[] { left, height });
		}

		Collections.sort(container, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		

		int max = 0;
		for (int i = 0; i < container.size(); i++) {
			if (max < container.get(i)[1]) {
				max = container.get(i)[1];
				center = i;
			}
		}

		leftSide();
		rightSide();
		res += max;

		System.out.println(res);
	}

	private static void leftSide() {

		int[] now = container.get(0);
		for (int i = 1; i <= center; i++) {
			if (now[1] <= container.get(i)[1]) {
				res += (container.get(i)[0] - now[0]) * now[1];
				now = container.get(i);
			}
		}
	}

	private static void rightSide() {

		int[] now = container.get(N - 1);
		for (int i = N - 2; i >= center; i--) {
			if (now[1] <= container.get(i)[1]) {
				res += (now[0] - container.get(i)[0]) * now[1];
				now = container.get(i);
			}
		}
	}
}