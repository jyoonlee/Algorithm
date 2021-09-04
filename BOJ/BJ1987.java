package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987 {
	static StringTokenizer st;
	static char[][] map;
	static int R, C, res = 1;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static boolean[] howmany;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		howmany = new boolean['Z' - 'A' + 1]; // 중복을 검열할 배열 

		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		howmany[map[0][0] - 'A'] = true; // 시작점은 무조건 포함
		check(0, 0, 1);

		System.out.println(res);
	}

	private static void check(int i, int j, int cnt) {

		// 사방탐색
		for (int idx = 0; idx < 4; idx++) {
			int ni = i + dy[idx];
			int nj = j + dx[idx];

			if (ni >= 0 && ni < R && nj >= 0 && nj < C && !howmany[map[ni][nj] - 'A']) { // 더 갈수 있다면 보내주고 
				int now = map[ni][nj] - 'A';
				howmany[now] = true;
				check(ni, nj, cnt+1);
				howmany[now] = false; // 값 쓴것은 반환해주기 
			} else { // 아니라면 값 갱신 후 가지치기 
				res = res < cnt ? cnt : res;
			}
		}

	}
}