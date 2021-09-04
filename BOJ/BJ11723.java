package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11723 {
	static final int SIZE = 21;
	static StringTokenizer st;
	static int[] parents;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		make(); // 초기 세팅
		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String now = st.nextToken();
			int value = 0;

			if (!now.equals("all") && !now.equals("empty")) // 명령어가 하나일 떄
				value = Integer.parseInt(st.nextToken());

			// 명령어 체크
			switch (now) {
			case "add":
				union(0, value); // 0으로 몰아주기
				break;

			case "remove":
				parents[value] = value; // 자기 자신으로 바꾸기
				break;

			case "check":
				if (find(value) == 0)
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;

			case "toggle":
				if (find(value) == 0) // 몰아져있다면
					parents[value] = value; // 제거
				else
					parents[value] = 0;
				break;

			case "all": // 몰아주기
				for (int idx = 1; idx < SIZE; idx++)
					union(0, idx);
				break;

			case "empty":
				make(); // 쪼개주기
				break;
			}
		}

		System.out.println(sb); // 시간초과 방지
	}

	// union-find
	private static void make() {
		parents = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aParents = find(a);
		int bParents = find(b);

		if (aParents == bParents)
			return false;

		parents[bParents] = aParents;
		return true;
	}
}
