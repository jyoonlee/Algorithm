package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1159_list {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int cnt = 0;
		sb.append("<");
		while (!list.isEmpty()) {
			cnt = (cnt + K - 1) % N--;
			sb.append(list.get(cnt)).append(", ");
			list.remove(cnt);
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
	}

}


