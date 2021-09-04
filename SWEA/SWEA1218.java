package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
	static String start = "([{<"; // 여는 괄호
	static String end = ")]}>"; // 닫는 괄호

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Loop: for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stack = new Stack<Character>();

			int N = Integer.parseInt(in.readLine());
			char[] list = in.readLine().toCharArray();

			for (char value : list) {
				if (end.indexOf(value) != -1) { // 만약 닫는 괄호라면?
					if (!stack.isEmpty() && start.indexOf(stack.peek()) == end.indexOf(value)) { // 매치가 된다면
						stack.pop(); // 스택에서 pop
						continue;
					} else { // 매치 안된다면 종료
						System.out.printf("#%d 0%n", test_case);
						continue Loop;
					}
				}
				stack.push(value); // 여는 괄호라면 추가
			}
			
			if (stack.isEmpty())
				System.out.printf("#%d 1%n", test_case);
			else
				System.out.printf("#%d 0%n", test_case);
		}
	}
}
