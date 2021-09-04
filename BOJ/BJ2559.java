package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열

public class BJ2559 {
	static StringTokenizer st;
	static int N, K;
	static int[] list;
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N - K + 1; i++) { // 인덱스 출발지 지정
			int sum = 0;
			for (int j = i; j < i + K; j++) // 범위 만큼
				sum += list[j];
			res = res < sum ? sum : res;
		}
		System.out.println(res);
	}
}