package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	static StringTokenizer st;
	static int N, M, start;
	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()) - 1;

		start = Integer.parseInt(st.nextToken()) - 1;

		adjList = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(adjList[i]);
		}

		dfs(start);
		System.out.println();
		bfs();

	}

	private static void dfs(int current) {

		visited[current] = true;
		System.out.print((current + 1) + " "); // 방문

		for (int i = 0; i < adjList[current].size(); i++) {
			if (!visited[adjList[current].get(i)]) {
				dfs(adjList[current].get(i));
			}
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((current + 1) + " ");

			for (int i = 0; i < adjList[current].size(); i++) {
				if (!visited[adjList[current].get(i)]) {
					queue.offer(adjList[current].get(i));
					visited[adjList[current].get(i)] = true;
				}
			}
		}
	}

}