package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3109 {
	static StringTokenizer st;
	static char[][] map;
	static int R, C, res;
	static int[] dy = { -1, 0, 1 };
	static boolean check[]; // 이미 가스관이 연결됐다면 가지치기

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R];

		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// 출발지 별로 가스관 탐색
		for (int i = 0; i < R; i++) {
			connect(i, i, 0);
		}

		System.out.println(res);
	}

	private static void connect(int start, int row, int cnt) { // start : 현재 연결하려고 하는 출발점 

		if (cnt == C - 1 && !check[start]) { // 출발점 첫 연결된다면 더이상 탐색하지 않도록 가지치기
			check[start] = true;
			res++;
			return;
		}

		if (check[start]) // 이미 연결됐다면 그만 탐색
			return;

		map[row][cnt] = 'x'; // 이 경로로 갈 경우 다시 올 일이 없으니 x로 지정 (무조건 탐색 성공하거나 실패함)
		for (int i = 0; i < 3; i++) {
			int nrow = row + dy[i];

			if (nrow < R && nrow >= 0 && map[row + dy[i]][cnt + 1] == '.') { // 조건 탐색
				connect(start, nrow, cnt + 1);
			} else
				continue;
		}
		return;
	}
}