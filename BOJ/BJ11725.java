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

public class BJ11725 {
	static StringTokenizer st;
	static int N;
	static List<Integer>[] adjList;
	static Queue<Integer> queue;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		adjList = new List[N]; // 인접 리스트
		parents = new int[N]; // 부모 저장할 배열
		visited = new boolean[N]; // 방문 조회

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>(); // 인접 리스트 초기화
		}

		// 노드 관계 입력
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			adjList[from].add(to);
			adjList[to].add(from);
		}

		// bfs 시작
		queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		bfs();

		for (int i = 1; i < N; i++) {
			System.out.println(parents[i] + 1);
		}
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int now = queue.poll();
			List<Integer> info = adjList[now];

			for (int i = 0; i < info.size(); i++) {
				if (!visited[info.get(i)]) { // 부모 저장
					visited[info.get(i)] = true;
					parents[info.get(i)] = now;
					queue.offer(info.get(i));
				}
			}
		}
	}
}
