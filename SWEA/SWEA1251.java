package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1251 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			List<int[]> vertexInfo = new ArrayList<>();

			boolean[] visited = new boolean[N]; // 방문했는 지
			double[] minEdge = new double[N]; // 최소 비용 유지
			double expense = 0.0;

			// 각 vertex의 x,y 좌표
			StringTokenizer st1 = new StringTokenizer(in.readLine());
			StringTokenizer st2 = new StringTokenizer(in.readLine());

			// vertex 관리
			for (int i = 0; i < N; i++) {
				vertexInfo.add(new int[] { Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()) });
			}

			// 비용 입력
			expense = Double.parseDouble(in.readLine());

			double result = 0; // 결과
			Arrays.fill(minEdge, Double.MAX_VALUE);
			minEdge[0] = 0; // 시작점

			for (int i = 0; i < N; i++) {

				double min = Double.MAX_VALUE;
				int minVertex = -1; // 정점

				// 가장 가까운 거리이면서, 방문하지 않은곳 찾기
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}

				visited[minVertex] = true; // 방문
				result += Math.pow(min, 2) * expense; // 비용 계산

				// 갱신
				for (int j = 0; j < N; j++) {
					if (!visited[j] && minEdge[j] > getDistance(vertexInfo.get(minVertex), vertexInfo.get(j))) {
						minEdge[j] = getDistance(vertexInfo.get(minVertex), vertexInfo.get(j));
					}
				}
			}

			long res = Math.round(result);
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static double getDistance(int[] o1, int[] o2) {
		
		double x = Math.pow(o1[0] - o2[0], 2);
		double y = Math.pow(o1[1] - o2[1], 2);
		return Math.sqrt(x + y);
	}
}
