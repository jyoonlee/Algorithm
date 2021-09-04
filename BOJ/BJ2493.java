package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		// 6 9 5 7 4

		for (int i = 0; i < N; i++) {

			int n = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() < n) {
				stack.pop();
				index.pop();
			}

			if (stack.isEmpty()) {
				sb.append(0 + " ");
			}

			else
				sb.append(index.peek() + 1 + " ");
			stack.push(n);
			index.push(i); // 69574
		}
		System.out.println(sb);
	}
}
