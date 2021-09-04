package com.ssafy.algorithm.JUNGNC;
//순열, 조합, 부분집합 기본 코드 연습하기.
//num 배열에 1,2,3,4가 들어가 있을때
//1. 주어진 4개의 숫자가 나열 될 수 있는 총 경우의 수를 구하는 코드 완성
//2. 4개의 숫자 중 3개를 선택할 수 있는 총 경우의 수를 구하는 코드 완성
//3. 4개의 숫자로 만들 수 있는 모든 조합의 총 경우의 수를 구하는 코드 완성

public class PCSPractice {
	static int N, R;
	static int num[];
	static int numbers_com[]; // 조합된 숫자 저장 배열
	static int numbers_per[]; // 순열용 숫자 저장 배열
	static boolean isSelected[]; // 선택 여부 확인을 위한 배열
	static int totalCount;

	public static void main(String[] args) {
		N = 4;
		R = 3;
		num = new int[] { 1, 2, 3, 4 };
		numbers_com = new int[R];
		numbers_per = new int[N];
		isSelected = new boolean[N];

		// 1. bit masking

		// permutation(0, 0);
		permutation2(0);
		System.out.println("총 경우의 수 : " + totalCount);
		totalCount = 0;

		// 2. next permutation

//		int[] check = new int[N];
//		for (int i = N - 1; i > N - R - 1; i--) {
//			check[i] = 1;
//		}
//
//		do {
//
//			int idx = 0;
//			for (int i = 0; i < N; i++) {
//				if (check[i] != 0) {
//					numbers_com[idx++] = num[i];
//				}
//			}
//			totalCount++;
//		} while (combination(check));
		combination2(0, 0);

		System.out.println("총 경우의 수 : " + totalCount);
		totalCount = 0;

		// 3. using bit
		// generateSubSet(num);
		generateSubSet2(0);
		System.out.println("총 경우의 수 : " + (totalCount)); // 공집합
	}

	// bit masking
	private static void permutation(int cnt, int flag) {
		if (cnt == N) {
			totalCount++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			numbers_per[cnt] = num[i];
			permutation(cnt + 1, (flag | 1 << i));
		}
	}

	private static void permutation2(int cnt) {
		if (cnt == N) {
			totalCount++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers_per[i] = num[i];
			isSelected[i] = true;
			permutation2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// next permutation
	private static boolean combination(int[] check) {

		int i = N - 1;
		while (i > 0 && check[i - 1] >= check[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (check[i - 1] >= check[j])
			j--;

		swap(check, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(check, i++, k--);
		}

		return true;
	}

	private static void combination2(int cnt, int start) {

		if (cnt == R) {
			totalCount++;
			return;
		}

		for (int i = start; i < N; i++) {
			numbers_com[cnt] = num[i];
			combination2(cnt + 1, i + 1);
		}

	}

	// using bit
	private static void generateSubSet(int[] num) {

		boolean flag = false;
		for (int i = 0; i < Math.pow(2, N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					flag = true;
				}
			}
			if (flag) {
				totalCount++;
				flag = false;
			}
		}

	}

	private static void generateSubSet2(int cnt) {

		if (cnt == N) {
			totalCount++;
			return;
		}

		isSelected[cnt] = true;
		generateSubSet2(cnt + 1);

		isSelected[cnt] = false;
		generateSubSet2(cnt + 1);
	}

	private static void swap(int[] check, int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}
}