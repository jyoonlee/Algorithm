package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
	static int H, W, N, y, x, now; // 맵의 세로, 가로, 명령 개수, 전차 위치(1), 전차 위치(2), 전차의 현재 방향
	static char[][] map;

	static int[] dy = { -1, 1, 0, 0 }; // 윗(0), 아래(1), 왼(2), 오른(3)
	static int[] dx = { 0, 0, -1, 1 }; // 윗(0), 아래(1), 왼(2), 오른(3)
	static String direction = "^v<>"; // ^(0), v(1), <(2), >(3)

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			StringBuilder sb = new StringBuilder();

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			boolean flag = false; // 처음 전차를 찾기 위한 변수

			// 맵 입력과 동시에 현재 전차 위치 찾기
			for (int i = 0; i < H; i++) {
				String s = in.readLine();
				map[i] = s.toCharArray(); // 맵 추가
				if (!flag) { // 전차 찾았다면 현재 좌표와 방향 저장
					for (int j = 0; j < W; j++) {
						if (map[i][j] != '.' && map[i][j] != '*' && map[i][j] != '#' && map[i][j] != '-') {
							y = i;
							x = j;
							now = direction.indexOf(map[i][j]); // ^(0),v(1),<(2),>(3) 초기 방향 설정
							flag = true;
						}
					}
				}
			} // 맵 입력과 전차 좌표, 방향 세팅 완료 

			// 명령 입력
			N = Integer.parseInt(in.readLine());
			String user = in.readLine();

			// 명령 실행
			for (int i = 0; i < N; i++) {
				switch (user.charAt(i)) {
				case 'S':
					shoot();
					break;
				case 'U':
					move(0); // 윗방향 direction[0] = ^, delta[0] = (-1,0)
					break;
				case 'D':
					move(1); // 아랫방향 direction[1] = v, delta[1] = (1,0)
					break;
				case 'L':
					move(2); // 왼쪽방향 direction[2] = <, delta[2] = (0,-1)
					break;
				case 'R':
					move(3); // 왼쪽방향 direction[3] = >, delta[3] = (0,1)
					break;
				}
			}
			
			map[y][x] = direction.charAt(now); // 전차 세팅 

			// 결과 출력
			sb.append("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}

	// 이동 명령
	static private void move(int change) {
		int i = y + dy[change];
		int j = x + dx[change];
		now = change; // 방향 바꿔주기

		// 범위 안이라면 전진 한번
		if (i >= 0 && i < H && j >= 0 && j < W && map[i][j] == '.') {
			map[y][x] = '.';
			y = i;
			x = j;
		}
	}

	// 포탄 발사
	static private void shoot() {
		int i = y;
		int j = x;

		while (true) {
			i += dy[now];
			j += dx[now];
			// 범위 밖이거나, 강철 벽 만날 경우 포탄 out
			if (i < 0 || i >= H || j < 0 || j >= W || map[i][j] == '#')
				break;
			else {
				// 벽돌 한번 만날 경우 포탄 소멸, 벽돌은 평지
				if (map[i][j] == '*') {
					map[i][j] = '.';
					break;
				}
			}
		}
	}
}
