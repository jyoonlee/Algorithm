package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 기존에 for문을 이용해서 풀었기 때문에 수업 시간에 배운 NextPermutation 이용해서 풀었습니다.

public class BJ15686 {
	static StringTokenizer st;
	static int N, M;
	static int map[][];
	static List<int[]> BBQ, home;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		BBQ = new ArrayList<>();
		home = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					home.add(new int[] { i, j });
				else if (n == 2)
					BBQ.add(new int[] { i, j });
			}
		}

		int[] check = new int[BBQ.size()];
		for (int i = BBQ.size() - 1; i > BBQ.size() - M - 1; i--) {
			check[i] = 1;
		}

		do {
			int[] nearby = new int[home.size()];
			Arrays.fill(nearby, Integer.MAX_VALUE);


			for (int i = 0; i < check.length; i++) {
				if (check[i] == 1) {
					for (int j = 0; j < home.size(); j++) {
						nearby[j] = Integer.min(Math.abs(home.get(j)[0] - BBQ.get(i)[0]) + Math.abs(home.get(j)[1] - BBQ.get(i)[1]), nearby[j]);
					}
				}
			}
			
			int dis = 0;
			for(int value : nearby) {
				dis += value;
			}
			
			res = Integer.min(res, dis);

		} while (np(check));
		
		System.out.println(res);

	}

	private static boolean np(int[] check) {

		int i = check.length - 1;
		while (i > 0 && check[i - 1] >= check[i])
			i--;

		if (i == 0)
			return false;

		int j = check.length - 1;
		while (check[i - 1] >= check[j])
			j--;

		swap(check, i - 1, j);

		int k = check.length - 1;
		while (i < k) {
			swap(check, i++, k--);
		}

		return true;
	}

	private static void swap(int[] check, int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}
}
