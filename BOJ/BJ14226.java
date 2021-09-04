package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14226 {
	static StringTokenizer st;
	static Queue<Info> queue;
	static int S;
	static boolean[][] checked = new boolean[1001][1001]; // 모니터, 클립보드 체크

	static class Info { // 객체 생성
		int monitor;
		int clipboard;
		int time;

		public Info(int monitor, int clipboard, int time) {
			this.monitor = monitor;
			this.clipboard = clipboard;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(in.readLine());

		queue = new LinkedList<>();
		checked[1][0] = true; // 모니터 1개, 클립보드 0
		queue.offer(new Info(1, 0, 0)); // 모니터 1개, 클립보드 0개, 시간 0초
		bfs();
	}

	private static void bfs() {

		while (!queue.isEmpty()) { // 탐색 시작
			Info now = queue.poll(); // 현재 모니터 상태

			if (now.monitor == S) { // 목표 개수라면 탈출
				System.out.println(now.time);
				return;
			}

			int i = now.monitor;
			int j = now.clipboard;

			// 너비 탐색
			if (i > 0 && i < 1001 && !checked[i][i]) {
				queue.offer(new Info(i, i, now.time + 1)); // 클립보드 복사
				checked[i][i] = true;
			}

			if (i + j < 1001 && !checked[i + j][j]) {
				queue.offer(new Info(i + j, j, now.time + 1)); // 클립보드 붙여넣기
				checked[i + j][j] = true;
			}

			if (i - 1 > 0 && !checked[i - 1][j]) {
				queue.offer(new Info(i - 1, j, now.time + 1)); // 모니터 이모티콘 하나 삭제
				checked[i - 1][j] = true;
			}
		}
	}

}
