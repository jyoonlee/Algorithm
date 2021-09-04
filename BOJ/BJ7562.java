package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
	static StringTokenizer st;
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;
	static int[] dest;
	static Queue<int[]> queue; // bfs를 위한 큐 
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(in.readLine());
			visited = new boolean[N][N];

			// 시작지
			st = new StringTokenizer(in.readLine());
			int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			// 도착지 
			st = new StringTokenizer(in.readLine());
			dest = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			// 시작지 등록
			queue = new LinkedList<>();
			visited[start[0]][start[1]] = true;
			queue.offer(start);

			bfs();
		}
	}

	private static void bfs() {
		int res = -1;

		while (!queue.isEmpty()) {

			int size = queue.size(); // 형제 노드 수 
 			res++;  // 몇번 타고 가나

			while (size-- > 0) {
				int[] now = queue.poll();

				if (now[0] == dest[0] && now[1] == dest[1]) { // 목적지에 도착했다면
					System.out.println(res);
					return;
				}

				for (int i = 0; i < 8; i++) { // 팔방 탐색
					int ni = now[0] + dy[i];
					int nj = now[1] + dx[i];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) { // 너비 우선 탐색
						queue.offer(new int[] { ni, nj }); // 큐에 등록
						visited[ni][nj] = true;
					}
				}
			}
		}
	}
}