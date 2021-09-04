package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309 {
	static int N = 9;
	static final int TOTAL = 100;

	public static void main(String[] args) throws Exception {

		int[] arr = new int[N];
		int sum = 0;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}

		Loop: for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum - arr[i] - arr[j] == TOTAL) {
					arr[i] = -1;
					arr[j] = -1;
					break Loop;
				}
			}
		}

		Arrays.sort(arr);

		for (int i = 2; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
