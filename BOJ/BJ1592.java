package com.ssafy.algorithm.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1592 {
	// 영식이와 친구들
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] circle = new int[N + 1];
		circle[1]++;
		int now = 1;
		int total = 0;

		while (true) {
			if (circle[now] % 2 == 1) {
				now += L;
				if (now > N)
					now -= N;
			} else {
				now -= L;
				if (now < 1)
					now += N;
			}

			circle[now]++;
			total++;

			if (circle[now] == M)
				break;
		}
		System.out.println(total);

	}

}
