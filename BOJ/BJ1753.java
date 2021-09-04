package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1753 {
	static final int MAX = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int V, E, start;
	static boolean[] visited;
	static int[] distance;
	static List<Node>[] adjList;

	// 노드 저장할 거리
	static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(in.readLine()) - 1;

		adjList = new ArrayList[V];
		distance = new int[V];
		visited = new boolean[V];

		// 노드 입력
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Node>();
			adjList[i].add(new Node(i, 0));
		}

		// 입력 받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Node(to, weight)); // 각각의 노드에 인접 정보 넣기
		}

		// 다익스트라 시작
		Arrays.fill(distance, MAX);

		distance[start] = 0;

		for (int i = 0; i < V; i++) {
			int current = -1;
			int min = MAX;

			// 최솟값 인덱스, 값 찾기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}

			if (current == -1)
				break;

			// 방문 설정
			visited[current] = true;
			List<Node> now = adjList[current];

			// 업데이트
			for (int j = 0; j < now.size(); j++) {
				if (!visited[now.get(j).to] && distance[now.get(j).to] > min + now.get(j).weight)
					distance[now.get(j).to] = min + now.get(j).weight;
			}
		}

		for (int value : distance) {
			if (value == MAX)
				System.out.println("INF");
			else
				System.out.println(value);
		}
	}
}
