package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1182 {
	static StringTokenizer st;
	static int N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int[] values = new int[N];
		int res = 0;

		// 입력
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		// 부분 집합 구하기
		for (int i = 1; i < Math.pow(2, N); i++) { // N^2가지의 수 
			int sum = 0;
			for (int j = 0; j < N; j++) { // N개의 인자 비교
				if ((i & 1 << j) != 0) // 만약 j번째 자리 수가 쓰인다면? 
					sum += values[j]; // 해당 값 더해주기
			}
			if (sum == S) // 전체 합과 비교
				res++;
		}
		
		System.out.println(res);
	}
}