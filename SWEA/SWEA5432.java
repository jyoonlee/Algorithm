package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA5432 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			Stack<Character> stack = new Stack<>();
			char[] ch = in.readLine().toCharArray();
			int result = 0;

			for (int i = 0; i < ch.length; i++) {
				if (ch[i] != ')') {
					stack.push(ch[i]);
				} else {
					if (stack.peek() != ch[i]) {
						stack.pop();
						result += stack.size();
					} else
						result++;
				}
			}
			System.out.println(result);
		}
	}
}
