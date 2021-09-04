package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ14501 {
	static StringTokenizer st;
	static int N, res = 0;
	static int[][] counsel;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		counsel = new int[N][2];

		// 일 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}

		getMoney(0, 0); // 조합
		System.out.println(res);
	}

	private static void getMoney(int start, int sum) {

		if (start >= N) { // 기저조건, 퇴사일 지났을 경우
			res = Integer.max(res, sum);
			return;
		}

		for (int i = start; i < N; i++) {
			if (i + counsel[i][0] <= N)
				getMoney(i + counsel[i][0], sum + counsel[i][1]); // 일 더하기 
			else
				getMoney(i + counsel[i][0], sum);
		}
	}
}
