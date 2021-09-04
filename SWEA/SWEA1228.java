package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class SWEA1228 {
	static int N, T;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {

			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			List<String> list = new LinkedList<>();

			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			T = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());

			while (st.hasMoreTokens()) {
				if (st.nextToken().equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int size = Integer.parseInt(st.nextToken());

					for (int j = 0; j < size; j++) {
						if (index <= N - 1)
							list.add(index++, st.nextToken());

						if (list.size() > N) {
							list.remove(list.size() - 1);
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
