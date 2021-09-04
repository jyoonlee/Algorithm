package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2851 {
	static StringTokenizer st;
	static int N, res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0, temp = 0;
		for (int i = 0; i < 10; i++) {
			int now = Integer.parseInt(in.readLine());

			if (sum + now >= 100) {
				temp = sum + now;
				break;
			} else
				sum += now;
		}

		res = temp - 100 <= 100 - sum ? temp : sum;
		System.out.println(res);
	}
}