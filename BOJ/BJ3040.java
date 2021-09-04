package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기존에 for문을 이용해서 풀었기 때문에 수업 시간에 배운 NextPermutation 이용해서 풀었습니다.

public class BJ3040 {
	static StringTokenizer st;
	static final int N = 9;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] happy = new int[N];
		int[] check = new int[N];
		int total = 0;
		int remain = 0;

		for (int i = 0; i < N; i++) {
			happy[i] = Integer.parseInt(in.readLine());
			total += happy[i];
		}

		remain = total - 100;

		for (int i = N - 1; i > N - 3; i--) {
			check[i] = 1;
		}

		do {

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (check[i] == 1)
					sum += happy[i];
			}

			if (remain == sum) {
				for (int i = 0; i < N; i++) {
					if (check[i] == 0)
						System.out.println(happy[i]);
				}
				break;
			}

		} while (findHappy(check));
	}

	private static boolean findHappy(int[] check) {

		int i = N - 1;

		while (i > 0 && check[i - 1] >= check[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (check[i - 1] >= check[j])
			j--;

		swap(check, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(check, i++, k--);
		}
		return true;
	}

	private static void swap(int[] happy, int i, int j) {
		int temp = happy[i];
		happy[i] = happy[j];
		happy[j] = temp;

	}
}
