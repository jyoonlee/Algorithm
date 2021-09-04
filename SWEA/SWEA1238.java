package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
	static int N, start, test_case, res;
	static final int SIZE = 101;
	static StringTokenizer st;
	static Node[] adjList;

	static class Node {
		int vertex; // 인접 정점 인덱스
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (test_case = 1; test_case <= 10; test_case++) {

			adjList = new Node[SIZE];

			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());

			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
			}

			bfs(start);

			// sb.append("#").append(test_case).append(" ").append().append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int now) {
		boolean[] visited = new boolean[SIZE];
		// 1. 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		// 2. 시작 정점 큐에 넣기 & 방문 처리
		queue.offer(now);
		visited[now] = true;

		// 3. 큐가 비어있지 않은 경우 반복
		while (!queue.isEmpty()) {
			// 해당 반복내에서 같은 level 탐색

			int size = queue.size();
			int curMaxNum = 0;
			while (size-- > 0) {
				// 4. 큐의 첫번째 원소 확인
				int num = queue.poll(); // 노드 번호
				// 같은 level에서 노드 번호가 큰 경우 확인 후 갱신
				curMaxNum = Math.max(curMaxNum, num);
				// 5. 원소(num)과 연결된 원소들을 확인 --> 간선 확인
				for (Node temp = adjList[num]; temp != null; temp = temp.link) {
					// 6. num의 인접 정점이면서, 방문하지 않은 정점
					if (!visited[temp.vertex]) {
						// 7. 큐에 넣고, 방문한 것으로 표시
						queue.offer(temp.vertex); // 다음 방문하기 위해 큐에 넣어주기
						visited[temp.vertex] = true; // 다음 방문할 번호들 방문 체크
					}
				}
			}
			res = curMaxNum;
		}
		System.out.printf("#%d %d%n", test_case, res);
	}
}