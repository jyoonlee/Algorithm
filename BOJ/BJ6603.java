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

public class BJ6603 {
	static StringTokenizer st;
	static final int SIZE = 6;
	static int[] pick;
	static int[] res;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());

			if (N == 0) // 0 입력 되면 종료 
				break;

			pick = new int[N]; // 입력된 수 
			res = new int[SIZE]; // 복권 결과

			for (int i = 0; i < N; i++)
				pick[i] = Integer.parseInt(st.nextToken()); // 수 입력

			combination(0, 0);
			System.out.println();
		}
	}

	// 조합 
	private static void combination(int start, int cnt) {
		if (cnt == SIZE) { // 조합이 완성되면 
			for (int i = 0; i < SIZE; i++) {
				System.out.print(res[i] + " "); // 복권 번호 출력
			}
			System.out.println();
			return;
		}

		// 조합 구하기
		for (int i = start; i < N; i++) {
			res[cnt] = pick[i];
			combination(i + 1, cnt + 1);
		}
	}
}
