package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1759 {
	static StringTokenizer st;
	static int L, C;
	static String[] input;
	static int[] check;
	static List<String> res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		res = new ArrayList<>();
		input = in.readLine().split(" "); // 입력 값
		check = new int[C];

		for (int i = 0; i < L; i++) // np를 위한 배열
			check[i] = 1;

		Arrays.sort(input); // 사전순으로 돌리기

		// next permutation
		do {
			int ja = 0;
			int mo = 0;

			String s = "";
			for (int i = 0; i < C; i++) {
				if (check[i] == 1) {
					if (input[i].equals("a") || input[i].equals("e") || input[i].equals("i") || input[i].equals("o") // 모음
																														// 카운팅
							|| input[i].equals("u"))
						ja++;
					else // 자음 카운팅
						mo++;

					s += input[i];
				}
			}
			if (ja >= 1 && mo >= 2) // 체크
				res.add(s);

		} while (np());

		Collections.sort(res); // 사전순으로 다시 나열

		for (String value : res) { // 출력
			System.out.println(value);
		}

	}

	private static boolean np() {

		int i = 0;

		while (i < C - 1 && check[i + 1] >= check[i])
			i++;

		if (i == C - 1)
			return false;

		int j = 0;

		while (check[i + 1] >= check[j])
			j++;

		swap(i + 1, j);

		int k = 0;

		while (i > k) {
			swap(i--, k++);
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}

}