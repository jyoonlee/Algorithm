package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2991 {
	static StringTokenizer st;
	static int A, B, C, D;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < 3; i++) {
			
			int cnt = 0;
			int num = Integer.parseInt(st.nextToken());

			if (A >= num % (A + B) && num % (A + B) != 0)
				cnt++;
			if (C >= num % (C + D) && num % (C + D) != 0)
				cnt++;

			System.out.println(cnt);
		}

	}
}
