package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14696 {
	static StringTokenizer st;
	static int N, K;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {

			int[] A = new int[5];
			int[] B = new int[5];

			st = new StringTokenizer(in.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				A[now]++;
			}

			st = new StringTokenizer(in.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				B[now]++;
			}

			int idx = 4;
			int res = 0;
			while (idx > 0) {
				if (A[idx] != B[idx]) {
					res = A[idx] > B[idx] ? 1 : 2;
					break;
				}
				idx--;
			}

			switch (res) {
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			}
		}
	}
}
