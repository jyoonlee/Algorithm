package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 리프노드라면 숫자
// 아니라면 연산자인지 확인하면 간단하게 풀 수 있음
public class SWEA1233 {
	static int N;
	static String[] list;
	static Stack<String> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {

			N = Integer.parseInt(in.readLine());
			list = new String[N + 1];
			stack = new Stack<>();

			boolean flag = false;
			int res = 1;

			// list에 노드 정보 넣기
			for (int i = 1; i <= N; i++) {
				String s = in.readLine().split(" ")[1];
				list[i] = s;
			}

			// DFS In-order
			check(1);

			// 연산식이 유효한 지 검사
			while (!stack.isEmpty()) {
				String value = stack.pop();

				if (value.equals("-") || value.equals("+") || value.equals("/") || value.equals("*")) {
					if (!flag) {
						res = 0;
						break;
					}
					flag = false;

				} else {
					if (flag) {
						res = 0;
						break;
					}
					flag = true;
				}
			}

			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	static void check(int index) {

		if (index * 2 <= N) {
			check(index * 2);
		}

		stack.push(list[index]);

		if (index * 2 + 1 <= N) {
			check(index * 2 + 1);
		}
	}
}
