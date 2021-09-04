package com.ssafy.algorithm.BOJ;

import java.util.Scanner;

public class BJ2798 {
	// 블랙잭
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int z = j + 1; z < N; z++) {

					if (result < arr[i] + arr[j] + arr[z] && arr[i] + arr[j] + arr[z] <= M)
						result = arr[i] + arr[j] + arr[z];
				}
			}
		}

		System.out.println(result);

	}

}
