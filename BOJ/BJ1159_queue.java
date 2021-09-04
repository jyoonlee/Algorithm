package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1159_queue {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int cnt = 0;
		sb.append("<");
		while (!queue.isEmpty()) {
			while (cnt < K - 1) {
				queue.offer(queue.poll());
				cnt++;
			}

			sb.append(queue.poll() + ", ");
			cnt = 0;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
	}

}
