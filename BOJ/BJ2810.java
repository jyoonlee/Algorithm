package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2810 {
	static StringTokenizer st;
	static int N;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		String sit = in.readLine();
		int people = sit.length();

		sit = sit.replace("LL", "S");
		int cup = sit.length() + 1;

		System.out.println(Math.min(people, cup));
	}
}
