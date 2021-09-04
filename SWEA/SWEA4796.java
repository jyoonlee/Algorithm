package com.ssafy.algorithm.SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA4796 {
	static int T, N, M;
	static List<Integer> now;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			sc.nextLine();
			now = new ArrayList<>();

			for (int i = 0; i < N; i++)
				now.add(sc.nextInt());

			// 내리막길부터 시작하면 제외
			int idx = 0;
			while (idx < N - 1 && now.get(idx) > now.get(idx + 1)) {
				now.remove(idx);

				if (now.size() == 1)
					break;
			}

			// 오르막길로 끝나면 제외
			idx = now.size() - 1;
			while (idx > 0 && now.get(idx) > now.get(idx - 1)) {
				now.remove(idx--);
			}

			if (now.size() == 1)
				System.out.printf("#%d 0%n", test_case);
			else {
				// 등산하기
				int res = 0;
				int up = 1;
				int flag = -1;
				for (int i = 0; i < now.size() - 1; i++) {
					if (now.get(i) < now.get(i + 1)) { // 올라간다
						if (flag == 0) // 새로 올라가는 거면 초기화
							up = 1;
						up++;
						flag = 1;
					} else {
						if (flag == 1) { // 꼭대기에 도달한거라면
							up--; // 꼭대기 빼주고
							flag = 0;
						}
						res += up; // 봉우리 세기
					}
				}
				System.out.printf("#%d %d%n", test_case, res);
			}
		}
	}
}