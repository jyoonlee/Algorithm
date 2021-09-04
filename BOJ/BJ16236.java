package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16236 {
	static final int MAX = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static List<Integer>[] adjList;
	static List<Fish> fishes;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Shark me;
	static int time = 0;

	// 상어 클래스
	static class Shark {
		int where;
		int size;
		int eat;

		public Shark(int where) {
			super();
			this.where = where;
			this.size = 2;
			this.eat = 0;
		}
	}

	// 물고기 클래스
	static class Fish implements Comparable<Fish> {
		int where;
		int size;

		public Fish(int where, int size) {
			super();
			this.where = where;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			return this.where - o.where;
		}
	}

	// 물고기로부터 상어 위치 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int V = N * N;

		adjList = new ArrayList[V]; // 인접 리스트
		fishes = new ArrayList<>(); // 물고기 정보 배열
		me = new Shark(0); // 상어 생성

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 인접 리스트 생성하기 (N*N개의 노드)
		int nodeNum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {

				int now = Integer.parseInt(st.nextToken());
				if (now != 0) {
					if (now == 9) // 주인공이라면 노드 정보 저장
						me.where = nodeNum;
					else {
						fishes.add(new Fish(nodeNum, now)); // 아니라면 물고기 정보 저장
					}
				}

				for (int z = 0; z < 4; z++) { // 사방탐색
					int ni = i + dy[z];
					int nj = j + dx[z];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N) { // 주변에 노드가 있다면

						// 인접 노드 정보를 저장한다.
						switch (z) {
						case 0:
							adjList[nodeNum].add(nodeNum - N);
							break;
						case 1:
							adjList[nodeNum].add(nodeNum + 1);
							break;
						case 2:
							adjList[nodeNum].add(nodeNum + N);
							break;
						case 3:
							adjList[nodeNum].add(nodeNum - 1);
							break;
						}
					}
				}
				nodeNum++; // 노드 번호 카운팅
			}
		}

		// 노드 번호가 작은 순으로 탐색이 진행되어야 한다.
		for (int i = 0; i < V; i++) {
			Collections.sort(adjList[i]);
		}

		Collections.sort(fishes);

		boolean finish = false;
		while (true) { // 물고기를 다 잡아먹거나, 더이상 잡아먹을 수 없을 때까지 탐색

			if (fishes.size() == 0) // 물고기 다 먹으면 break
				break;

			int path = Integer.MAX_VALUE;
			int who = 0;
			boolean flag = false;

			for (int idx = 0; idx < fishes.size(); idx++) {
				if (fishes.get(idx).size >= me.size)
					continue;

				flag = true;
				int start = fishes.get(idx).where;

				int[] distance = new int[V];
				boolean[] visited = new boolean[V];
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

					if (current == me.where || current == -1) // 물고기 찾았다면 탈출
						break;

					visited[current] = true;
					List<Integer> now = adjList[current];

					Loop: for (int j = 0; j < now.size(); j++) {
						if (!visited[now.get(j)] && distance[now.get(j)] > min + 1)
							for (int z = 0; z < fishes.size(); z++) {
								if (fishes.get(z).where == now.get(j) && fishes.get(z).size > me.size)
									continue Loop;
							}
						distance[now.get(j)] = min + 1;
					}
				}

				if (path > distance[me.where]) {
					path = distance[me.where];
					who = idx;
				}
			}

			if (!flag || path == Integer.MAX_VALUE) // 한마리도 먹을게 없다면 탈출
				break;
			else {
				me.where = fishes.get(who).where;
				fishes.remove(who);
				if (me.size == ++me.eat) {
					me.size++;
					me.eat = 0;
				}

				time += path;
			}
		}
		System.out.println(time);
	}
}
