package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5215 {
	static int N, limit;
	static StringTokenizer st;
	static int res, now, sum;
	static List<int[]> burger;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());

			burger = new ArrayList<>();
			res = 0;

			for (int i = 0; i < N; i++) { // 입력
				st = new StringTokenizer(in.readLine());
				burger.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			for (int i = 0; i < N; i++) { // 탐색
				check(i, burger.get(i)[0], burger.get(i)[1]);
			}

			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static void check(int i, int sum, int now) {

		for (int j = i + 1; j < N; j++) {
			if (now + burger.get(j)[1] > limit) { // 엔딩 포인트
				res = Integer.max(sum, res);
				continue;
			}
			sum += burger.get(j)[0];
			now += burger.get(j)[1];
			check(j, sum, now); // 다시 탐색
			sum -= burger.get(j)[0];
			now -= burger.get(j)[1];
		}

		if (now <= limit) { // 재료의 총 열량이 제한 열량보다 적을 경우 
			res = Integer.max(sum, res);
		}
	}
}

//1
//5 1000
//100 200
//300 500
//250 300
//500 1000
//400 400
