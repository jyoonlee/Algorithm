package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961 {
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		int[][] cook = new int[N][2];
		int res = Integer.MAX_VALUE;

		// 2차원 배열에 신맛, 쓴맛 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			cook[i][0] = Integer.parseInt(st.nextToken());
			cook[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < Math.pow(2, N); i++) { // 부분 집합
			
			int sin = 1;
			int ssn = 0;

			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sin *= cook[j][0];
					ssn += cook[j][1];
				}
			}
			res = Integer.min(res, Math.abs(sin - ssn));
		}
		System.out.println(res);
	}
}
