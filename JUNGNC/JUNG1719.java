package com.ssafy.algorithm.JUNGNC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNG1719 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N % 2 == 0 || N < 0 || N > 100 || M < 1 || M > 4) {
			System.out.println("INPUT ERROR!");

		} else {
			switch (M) {
			case 1:
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j <= i; j++)
						System.out.print('*');
					System.out.println();
				}
				for (int i = N / 2; i < N; i++) {
					for (int j = 0; j < N - i; j++)
						System.out.print('*');
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < N / 2; i++) {
					for (int z = 0; z < N / 2 - i; z++)
						System.out.print(" ");
					for (int j = 0; j <= i; j++)
						System.out.print('*');
					System.out.println();
				}
				for (int i = N / 2; i < N; i++) {
					for (int z = 0; z < i - N / 2; z++)
						System.out.print(" ");
					for (int j = 0; j < N - i; j++)
						System.out.print('*');
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N / 2; i++) {
					for (int z = 0; z < i; z++)
						System.out.print(" ");
					for (int j = 0; j < N - 2 * i; j++)
						System.out.print('*');
					System.out.println();
				}
				for (int i = N / 2; i < N; i++) {
					for (int z = 0; z < N - i - 1; z++)
						System.out.print(" ");
					for (int j = 0; j <= 2 * i - N + 1; j++)
						System.out.print('*');
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < N / 2; i++) {
					for (int z = 0; z < i; z++)
						System.out.print(" ");
					for (int j = N / 2 - i; j >= 0; j--)
						System.out.print('*');
					System.out.println();
				}
				for (int i = N / 2; i <= N - 1; i++) {
					for (int z = 0; z < N / 2; z++)
						System.out.print(" ");
					for (int j = 0; j <= i - N / 2; j++)
						System.out.print('*');
					System.out.println();
				}

			}

		}

	}

}
