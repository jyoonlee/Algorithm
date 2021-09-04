package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2999 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		N = s.length();
		int y = 0, x = 0;

		// 약수 구하기 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) { // R은 C보다 크면 안된다.
				if (i * j == N && Integer.max(x, j) == j) { // j가 가장 큰 수를 뽑아주기 위해 
					y = i;
					x = j;
				}
			}
		}

		char[][] cryptograph = new char[x][y]; // 새로운 테이블로 생성 
		int idx = 0;
		for (int j = 0; j < y; j++) { // 열부터 넣어주기 
			for (int i = 0; i < x; i++) {
				cryptograph[i][j] = s.charAt(idx++); // 스트링 순서대로 
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(cryptograph[i][j]);
			}
		}
	}
}
