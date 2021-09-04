package com.ssafy.algorithm.BOJ;

import java.util.Scanner;

public class BJ8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int res = 0;
		int value = 0; // 정사각형

		Loop: for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				
				// 지나간거
				if (i * j > num)
					continue;
				
				// i =  3 , j = 3  ==> 정사각형 
				if (i == j && i * j <= num) {
					value++;
					continue;
				} else
					res++; //  1*4 , 4*1 => 같은 사각형 

			}
		}

		System.out.println((res / 2) + value);

	}

}
