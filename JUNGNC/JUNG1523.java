package com.ssafy.algorithm.JUNGNC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNG1523 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N < 0 || N > 100 || M < 1 || M > 3) {
			System.out.println("INPUT ERROR!");

		} else {
			switch (M) {
			case 1:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j <= i; j++)
						System.out.print('*');
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = N; j > i; j--)
						System.out.print('*');
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N; i++) {
					for (int j = N-i-1; j > 0; j--)
						System.out.print(" ");
					for (int j = 0; j <= i*2; j++)
						System.out.print('*');
					System.out.println();
				}

			}

		}

	}

}
