package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			Queue<Object> queue1 = new LinkedList<>();
			Queue<Object> queue2 = new LinkedList<>();

			int N = Integer.parseInt(in.readLine());
			int i = 1;
			int center = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());

			// 반토막씩 queue에 넣어주기 
			while (st.hasMoreTokens()) {
				if (i <= (N+1)/2)
					queue1.offer(st.nextToken()); //
				else
					queue2.offer(st.nextToken());

				i++;
			}

			// queue에서 하나씩 꺼내오면서 출력
			System.out.printf("#%d ",test_case);
			while (!queue1.isEmpty()) {
				System.out.print(queue1.poll() + " ");

				if (queue2.isEmpty())
					break;
				System.out.print(queue2.poll() + " ");
			}
			System.out.println();
		}
	}
}
