package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_priorityQ_v1 {
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int index;
		int weight;

		public Node(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(in.readLine()) - 1;

		LinkedList<int[]>[] adjList = new LinkedList[V]; // 리스트를 관리할 배열 생성

		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>(); // 리스트 할당
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new int[] { to, weight });
		}

		// 비용 배열 최대 값으로 초기화
		int[] distance = new int[V];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int[] node : adjList[now.index]) {
				int newCost = now.weight + node[1];
				if (distance[node[0]] <= newCost)
					continue;
				distance[node[0]] = newCost;
				queue.add(new Node(node[0], newCost));
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : distance) {
			if (i != INF)
				sb.append(i);
			else
				sb.append("INF");
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
