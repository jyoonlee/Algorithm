package com.ssafy.algorithm.BOJ;

import java.util.Arrays;
import java.util.Scanner;

// ATM
public class BJ11399 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int res = 0;
		int delay = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			res += (delay + arr[i]);
			delay += arr[i];
		}

		System.out.println(res);
	}

}
