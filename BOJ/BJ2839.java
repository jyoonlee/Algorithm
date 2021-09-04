package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		int N = Integer.parseInt(in.readLine());

		while (true) {
			if (N % 5 == 0) {
				cnt += N / 5;
				break;
			} else {
				N -= 3;
				cnt++;

				if (N < 0) {
					cnt = -1;
					break;
				} 
			}
		}
		
		System.out.println(cnt);
	}

}
