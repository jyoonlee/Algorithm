package com.ssafy.algorithm.SWEA;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1223 {
	static int N;
	static StringTokenizer st;
	static Stack<Integer> res;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {

			N = Integer.parseInt(in.readLine());
			String change = "";
			stack = new Stack<>();
			String s = in.readLine();

			int idx = 0;
			// 후위 표기법으로 바꾸기
			while (idx < N) {
				char now = s.charAt(idx);
				if (Character.isDigit(now)) { // 숫자인지 판별
					change += now; // 문자열에 바로 넣어주기
				} else {
					if (stack.isEmpty()) // 비어있다면 수식 스택에 넣어주기
						stack.push(now);
					else {
						if (stack.peek() > now) // 아스키 코드 비교 (*, +)
							stack.push(now); // 우선순위가 높다면 스택에 넣어주기
						else {
							while (!stack.isEmpty() && stack.peek() <= now) { // 같거나 우선순위가 낮다면
								change += stack.pop(); // 스택 다 꺼내주기
							}
							stack.push(now); // now 스택에 넣는다
						}
					}
				}
				idx++;
			}

			while (!stack.isEmpty()) {
				change += stack.pop(); // 마지막 남은 친구들
			}

			idx = 0;

			res = new Stack<>(); // 연산을 위해 새롭게
			while (idx < N) {
				char now = change.charAt(idx);
				if (Character.isDigit(now)) {
					res.push(now - '0'); // 숫자라면 스택에 넣어준다 
				} else { // 연산자를 만나면 
					int num1 = res.pop();
					int num2 = res.pop();
					// 수 두개 꺼내서 

					switch (now) { // 연산한 뒤 다시 스택에 넣는다.
					case '+':
						res.push(num1 + num2);
						break;
					case '*':
						res.push(num1 * num2);
						break;
					}
				}
				idx++;
			}

			sb.append("#").append(test_case).append(" ").append(res.pop()).append("\n");
		}
		System.out.println(sb);

	}
}