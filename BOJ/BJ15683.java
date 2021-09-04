package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15683 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static List<CCTV> cctvs;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[] direction;
	static int min = Integer.MAX_VALUE;

	// cctv 정보를 저장하는 객체
	static class CCTV {
		int type;
		int i;
		int j;

		CCTV(int type, int i, int j) {
			this.type = type;
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 맵 입력하면서 CCTV 객체 담음
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(map[i][j], i, j));
				}
			}
		}

		// cctv가 각각 가리킬 수 있는 방향을 찾자
		direction = new int[cctvs.size()];

		// 중복 순열
		blindSpot(0);

		System.out.println(min);
	}

	private static void blindSpot(int cnt) {

		// 방향이 다 결정 되었다면
		if (cnt == cctvs.size()) {
			int res = findOut(); // 사각지대를 찾아서 결과 값으로 불러오자
			min = Integer.min(min, res);
			return;
		}

		// 중복 순열
		for (int i = 0; i < 4; i++) {
			direction[cnt] = i;
			blindSpot(cnt + 1);
		}

	}

	private static int findOut() {

		// 체크를 위해 맵을 하나 더 만듬 (시뮬)
		boolean[][] check = new boolean[N][M];

		for (int idx = 0; idx < cctvs.size(); idx++) {
			// CCTV 정보를 불러온 뒤
			CCTV now = cctvs.get(idx);
			int type = now.type;
			int y = now.i;
			int x = now.j;
			int dir = direction[idx]; // 중복 순열로 만들어진 현재 CCTV의 방향
			int ni = 0;
			int nj = 0;

			switch (type) { // CCTV의 종류에 따라 temp 맵에 볼 수 있는 범위를 찍어줌

			case 1: // 델타 탐색 (한 방향)
				ni = y + dy[dir];
				nj = x + dx[dir];

				while (true) {

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 6) {
						check[ni][nj] = true;
						ni += dy[dir];
						nj += dx[dir];

					} else
						break;

				}
				break;

			case 2: // 델타 탐색 (좌우 or 상하니까 델타 인덱스는 +2씩 두개)
				for (int i = 0; i < 3; i += 2) {
					ni = y + dy[(dir + i) % 4];
					nj = x + dx[(dir + i) % 4];

					while (true) {

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 6) {
							check[ni][nj] = true;
							ni += dy[(dir + i) % 4];
							nj += dx[(dir + i) % 4];
						} else
							break;
					}
				}
				break;

			case 3: // 델타 탐색(직각 방향이니까 델타 인덱스는 +1씩 두개)
				for (int i = 0; i < 2; i++) {
					ni = y + dy[(dir + i) % 4];
					nj = x + dx[(dir + i) % 4];

					while (true) {
						if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 6) {
							check[ni][nj] = true;
							ni += dy[(dir + i) % 4];
							nj += dx[(dir + i) % 4];
						} else
							break;
					}
				}
				break;

			case 4: // 델타 탐색(ㅗ, ㅜ 방향이니까 델타 인덱스는 +1씩 세개)
				for (int i = 0; i < 3; i++) {
					ni = y + dy[(dir + i) % 4];
					nj = x + dx[(dir + i) % 4];

					while (true) {
						if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 6) {
							check[ni][nj] = true;
							ni += dy[(dir + i) % 4];
							nj += dx[(dir + i) % 4];
						} else
							break;
					}

				}

				break;

			case 5: // 델타 탐색(사방 탐색 한번)
				for (int i = 0; i < 4; i++) {
					ni = y + dy[i];
					nj = x + dx[i];

					while (true) {

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 6) {
							check[ni][nj] = true;
							ni += dy[i];
							nj += dx[i];
						} else
							break;
					}
				}
				break;
			}
		}

		// 다 찍어줬다면, 사각지대를 카운팅
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j] && map[i][j] == 0)
					cnt++;
			}
		}
		return cnt; // 사각지대 범위 리턴
	}
}