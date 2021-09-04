package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ10819 {
	static StringTokenizer st;
	static int N;
	static int[] values;
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		values = new int[N];

		st = new StringTokenizer(in.readLine());

		// 데이터 입력 
		int idx = 0;
		while (st.hasMoreTokens())
			values[idx++] = Integer.parseInt(st.nextToken());

		Arrays.sort(values); // Next Permutation을 위해 정렬(오름차순)

		do {
			findMax(); // 순열 생성 
		} while (np());

		System.out.println(res);
	}

	private static boolean np() {

		int size = N - 1;

		int i = size;
		while (i > 0 && values[i - 1] >= values[i]) // 꼭대기 탐색 
			i--;

		if (i == 0)
			return false;

		int j = size;
		while (values[i - 1] >= values[j]) // 바로 다음 값 찾기 
			j--;

		swap(i - 1, j--);

		int k = size;
		while (i < k) // 뒤집어 주기
			swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	private static void findMax() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) // 만들어진 순열로 계산
			sum += Math.abs(values[i] - values[i + 1]);

		res = Integer.max(sum, res);
	}

}
