package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1225 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int test_case = 1; test_case <= 10; test_case++) {

			Queue<Integer> queue = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int count = 1;

			while (st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			while (true) {
				if (queue.peek() - count <= 0) {
					queue.poll();
					queue.offer(0);
					break;
				}

				queue.offer(queue.poll() - count);
				if (count >= 5) {
					count = 0;
				}
				count++;
			}

			sb.append("#" + test_case + " ");
			while (!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			System.out.println(sb);
		}
	}
}
