package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1247 {
	static int N;
	static int[][] myPlace;
	static List<int[]> customer;
	static int[] path;
	static StringTokenizer st;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(in.readLine());

			myPlace = new int[2][2]; // 회사와 집
			path = new int[N]; // 경로
			customer = new ArrayList<>(); // 고객 집
			res = Integer.MAX_VALUE;

			st = new StringTokenizer(in.readLine());
			myPlace[0][0] = Integer.parseInt(st.nextToken()); // 회사
			myPlace[0][1] = Integer.parseInt(st.nextToken());
			myPlace[1][0] = Integer.parseInt(st.nextToken()); // 집
			myPlace[1][1] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				customer.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) }); // 고객 집 정보 입력
			}

			letsGoHome(0, 0); // 순열

			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void letsGoHome(int cnt, int flag) {

		if (cnt == N) { // 경로 완성

			int sum = 0;
			sum += Math.abs(myPlace[0][0] - customer.get(path[0])[0]) // 회사 - 첫번째 고객
					+ Math.abs(myPlace[0][1] - customer.get(path[0])[1]);

			for (int i = 0; i < N - 1; i++) { // 고객들 간 거리
				sum += Math.abs(customer.get(path[i])[0] - customer.get(path[i + 1])[0])
						+ Math.abs(customer.get(path[i])[1] - customer.get(path[i + 1])[1]);
			}

			sum += Math.abs(myPlace[1][0] - customer.get(path[N - 1])[0]) // 마지막 고객 - 집
					+ Math.abs(myPlace[1][1] - customer.get(path[N - 1])[1]);

			res = Integer.min(sum, res);
			return;
		}

		// 순열
		for (int i = 0; i < N; i++) {

			if ((flag & 1 << i) != 0)
				continue;

			path[cnt] = i;
			letsGoHome(cnt + 1, flag | 1 << i);
		}
	}
}