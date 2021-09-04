package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3985 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(in.readLine()); // 롤케이크 길이
		int S = Integer.parseInt(in.readLine()); // 방청객 수

		int[] cake = new int[L]; // 배열로 만들기
		int max = 0; // 가장 많이 먹고 싶어하는 사람
		int res = 0; // 실제로 많이 먹은 사람 
		int S1 = 0;
		int S2 = 0;

		for (int i = 1; i <= S; i++) { // 방청객 돌아가면서

			// 난 여기부터 여기까지 먹을꺼야
			st = new StringTokenizer(in.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 길이 최대 값 (가장 많을 조각을 받을 사람은?)
			if (max < K - P + 1) {
				S1 = i;
				max = K - P + 1;
			}

			int count = 0;
			// P부터 K까지 0이면 체크 표시
			for (int j = P - 1; j <= K - 1; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					count++; // 받은 개수
				}
			}

			// 더 많이 받았으면 갱신
			if (res < count) {
				S2 = i;
				res = count;
			}
		}
		System.out.println(S1 + "\n" + S2);
	}
}
