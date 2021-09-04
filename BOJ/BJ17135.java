package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ17135 {
	static StringTokenizer st;
	static int N, M, D;
	static int map[][];
	static int[][] archer; // archer들의 위치를 담을 배열 (조합을 위해)
	static int res, temp; // res: 결과값, temp: 조합 각각에서 죽인 적의 수

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 궁수 조합을 위한 준비 (자리 입력)
		int[] check = new int[M];
		archer = new int[M][2]; // M열 만큼 x,y 좌표 담아주기 위해

		// 궁수가 올 수 있는 자리 입력
		for (int i = 0; i < M; i++) {
			archer[i][0] = N;
			archer[i][1] = i;
		}

		// Next Permutation 준비
		for (int i = M - 1; i > M - 4; i--) {
			check[i] = 1;
		}

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// np와 함께 게임 시작
		do {
			// np로 받은 경우의 수 전송
			attack(check);
			res = Integer.max(temp, res); // 위 조합으로 적을 죽였을 때가 최소값이라면 갱신
			temp = 0;
		} while (np(check));

		System.out.println(res);

	}

	// Next Permutation
	private static boolean np(int[] check) {

		int i = M - 1;
		while (i > 0 && check[i - 1] >= check[i])
			i--;

		if (i == 0)
			return false;

		int j = M - 1;
		while (check[i - 1] >= check[j])
			j--;

		swap(check, i - 1, j);

		int k = M - 1;
		while (i < k) {
			swap(check, i++, k--);
		}

		return true;
	}

	private static void swap(int[] check, int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}

	private static void attack(int[] check) {

		// 맵 복사
		int[][] tempMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		int idx = 0; // 궁사들이 앞으로 전진하기 위해
		while (idx < N) {
			// 적이 다 소멸

			// 조합에서 궁사를 뽑아온다
			for (int i = 0; i < check.length; i++) {

				if (check[i] == 1) {
					int min = D; // 궁사와 적의 가장 가까운 거리
					int dy = 0, dx = M; // 적의 좌표를 담을 값

					for (int y = 0; y < N - idx; y++) { // 맵 탐색 (idx를 빼는 이유는 궁사들의 전진을 위해)
						for (int x = 0; x < M; x++) {

							int distance = Math.abs(archer[i][0] - idx - y) + Math.abs(archer[i][1] - x); // 거리 계산

							if (tempMap[y][x] >= 1 && distance <= min) { // 적을 발견했고 사정 범위 내에 있을 때
								if (distance == min && x > dx) // 만약 사정 범위가 같은 경우가 있다면, 열이 우선인 적을 죽여야 한다.
									continue;
								else { // 이 적이 이상적이라면 저장
									min = distance;
									dy = y;
									dx = x;
								}
							}
						}
					}
					if (dx != M) // 죽일 적을 찾지 못한 경우가 아니라면 적의 자리에 + 1
						tempMap[dy][dx] += 1;
				}
			}

			// 3명의 궁사가 공격이 끝난 후에는 볼 수 있는 범위 내에서 적을 찾고, 해당 적을 없애준다.
			for (int y = 0; y < N - idx; y++) {
				for (int x = 0; x < M; x++) {
					if (tempMap[y][x] > 1) { // 공격받은 적 발견
						temp++; // 카운팅
						tempMap[y][x] = 0; // 적 제거
					}
				}
			}
			idx++;
		}

	}
}
