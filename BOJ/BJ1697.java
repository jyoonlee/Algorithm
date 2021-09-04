package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {
	static StringTokenizer st;
	static boolean[] visited = new boolean[1000001];
	static int N, K;
	static Queue<Integer> queue;
	static int res = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();

		queue.offer(N); // 첫 위치
		visited[N] = true;

		bfs(N);
		System.out.println(res);
	}

	private static void bfs(int now) {

		while (!queue.isEmpty()) {

			res++; // 처음 비교 (바로 찾을 수도 있음)
			int size = queue.size();

			while (size-- > 0) { // 너비 탐색, 같은 너비는 같은 횟수
				int node = queue.poll(); // 형제 노드 확인
				if (node == K) // 찾았다 ! 
					return;

				if (node - 1 >= 0 && !visited[node - 1]) { // 방문 여부 체크
					queue.offer(node - 1);
					visited[node - 1] = true;
				}
				if (node + 1 <= 100000 && !visited[node + 1]) {
					queue.offer(node + 1);
					visited[node + 1] = true;
				}
				if (node * 2 <= 100000 && !visited[node * 2]) {
					queue.offer(node * 2);
					visited[node * 2] = true;
				}
			}
		}
	}
}
