package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13300 {
	static StringTokenizer st;
	static int N, K;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] rooms = new int[7][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			rooms[age][gender]++;
		}

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				res += rooms[i][j] / K;
				if (rooms[i][j] % K != 0)
					res++;
			}
		}

		System.out.println(res);
	}
}
