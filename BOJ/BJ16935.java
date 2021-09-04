package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16935 {
	static StringTokenizer st;
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// array 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 명령 받아오기
		st = new StringTokenizer(in.readLine());

		// 명령 돌리기
		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				updown(); // 상하 반전
				break;
			case 2:
				reverse(); // 좌우 반전
				break;
			case 3:
				right(); // 오른쪽으로 90도 회전
				break;
			case 4:
				left(); // 왼쪽으로 90도 회전
				break;
			case 5:
				moveOne(); // 4분할 시계방향
				break;
			case 6:
				moveTwo(); // 4분할 반시계방향
				break;

			}

		}

		// 출력
		for (int[] value : map) {
			for (int n : value) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}

	// 상하 반전
	public static void updown() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		for (int i = N - 1; i >= 0; i--) { // 인덱스 역순으로 array 갱신
			for (int j = 0; j < M; j++) {
				map[N - i - 1][j] = temp[i][j];
			}
		}
	}

	// 좌우 반전
	public static void reverse() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) { // 인덱스 역순으로 array 갱신
				map[i][M - j - 1] = temp[i][j];
			}
		}
	}

	// 오른쪽으로 90도 회전
	public static void right() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		// array 모양이 바뀌므로 N, M 값 업데이트
		int value = M;
		M = N;
		N = value;

		map = new int[N][M];
		for (int j = 0; j < N; j++) {
			for (int i = M - 1; i >= 0; i--) { // column 역순으로 array 정렬
				map[j][M - i - 1] = temp[i][j];
			}
		}

	}

	// 왼쪽으로 90도 회전
	public static void left() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		// array 모양이 바뀌므로 N, M 값 업데이트
		int value = M;
		M = N;
		N = value;

		map = new int[N][M];
		for (int j = N - 1; j >= 0; j--) { // row 역순으로 array 정렬
			for (int i = 0; i < M; i++) {
				map[N - j - 1][i] = temp[i][j];
			}
		}
	}

	public static void moveOne() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		// 절반 계산
		int y = N / 2;
		int x = M / 2;

		// 인덱스 케이스 4분할로 나눠서 array 업데이트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < y && j < x)
					map[i][j + x] = temp[i][j];
				else if (i < y && j >= x)
					map[i + y][j] = temp[i][j];
				else if (i >= y && j < x)
					map[i - y][j] = temp[i][j];
				else if (i >= y && j >= x)
					map[i][j - x] = temp[i][j];
			}
		}

	}

	public static void moveTwo() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}

		// 절반 계산
		int y = N / 2;
		int x = M / 2;

		// 인덱스 케이스 4분할로 나눠서 array 업데이트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < y && j < x)
					map[i + y][j] = temp[i][j];
				else if (i < y && j >= x)
					map[i][j - x] = temp[i][j];
				else if (i >= y && j < x)
					map[i][j + x] = temp[i][j];
				else if (i >= y && j >= x)
					map[i - y][j] = temp[i][j];
			}
		}

	}

}
