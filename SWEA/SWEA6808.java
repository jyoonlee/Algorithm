package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA6808 {
	static final int TOTAL = 9;
	static int[] p1 = new int[TOTAL];
	static int[] p2 = new int[TOTAL];
	static int[] temp = new int[TOTAL];
	static int win, lose;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			int[] check = new int[(TOTAL * 2) + 1];
			
			// 규영이 카드 입력 받기
			for (int i = 0; i < TOTAL; i++) {
				p1[i] = Integer.parseInt(st.nextToken());
				check[p1[i]] = 1;
			}

			// 인영이 카드 입력 
			int idx = 0;
			for (int i = 1; i <= TOTAL * 2; i++) {
				if (check[i] == 0) {
					p2[idx++] = i;
				}
			}

			// 순열 시작, 게임 승패 탐색
			gameStart(0, 0);

			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
			win = 0;
			lose = 0;
		}
		System.out.println(sb);
	}

	static void gameStart(int cnt, int flag) {

		// 게임 승패
		if (cnt == TOTAL) {
			int pnt1 = 0;
			int pnt2 = 0;

			for (int i = 0; i < TOTAL; i++) {
				if (p1[i] > temp[i])
					pnt1 += (p1[i] + temp[i]);
				else
					pnt2 += (p1[i] + temp[i]);
			}

			if (pnt1 > pnt2)
				win++;
			else
				lose++;
			return;
		}

		// 순열
		for (int i = 0; i < TOTAL; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			temp[cnt] = p2[i];
			gameStart(cnt + 1, flag | 1 << i);

		}
	}
}
