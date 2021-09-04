package com.ssafy.algorithm.BOJ;
import java.util.Scanner;

public class BJ2615 {

	// 사방 둘레를 한칸씩 더 두어 범위 체크를 하지 않아도 되도록 크기 설정
	static int[][] board = new int[21][21];

	static int[] dy = { 1, 0, 1, -1 };// 행인덱스
	static int[] dx = { 0, 1, 1, 1 };// 열인덱스
	// 하, 우, 우하, 우상

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {

				int currVal = board[i][j]; // 흑돌1 백돌2 없음0

				if (currVal == 0)
					continue;

				for (int k = 0; k < 4; k++) {// k : 4개 방향을 표현
					int count = 1;
					int ny = dy[k];// 진행방향의 새로운 행인덱스
					int nx = dx[k];// 진행방향의 새로운 열인덱스

					// 지금 체크하려는 값이 이전에 체크된 값인지 확인하여 이전에 확인한 루틴이라면 가지치기
					if (currVal == board[i + dy[k] * -1][j + dx[k] * -1])
						continue;
					// 지금 시작점 반대방향 바로 전의 값!!

					while (currVal == board[i + ny][j + nx]) {
						count++;
						ny += dy[k];
						nx += dx[k];
					}
					if (count == 5) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(0); // 무승부 출력
		sc.close();
	}// main
}