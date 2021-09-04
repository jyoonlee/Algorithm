package com.ssafy.algorithm.SWEA;

import java.util.Scanner;

public class SWEA7272 {
	// 안경이 없어!
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		Loop: for (int test_case = 1; test_case <= T; test_case++) {
			char[] s1 = sc.next().toCharArray();
			char[] s2 = sc.next().toCharArray();

			if (s1.length != s2.length)
				System.out.println("DIFF");
			else {

				for (int i = 0; i < s1.length; i++) {
					if (check(s1[i]) != check(s2[i])) {
						System.out.println("DIFF");
						continue Loop;
					}
				}
				System.out.println("SAME");

			}
		}
	}

	public static int check(char a) {
		
		switch(a) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			return 1;
		case 'B':
			return 2;
		default:
			return 0;
		}

	}
}
