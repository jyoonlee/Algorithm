package com.ssafy.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2116 {
	static StringTokenizer st;
	static final int num = 6;
	static int N;
	static List<int[]> dices;
	static int sum, res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		dices = new ArrayList<>(N); // 주사위 정보를 담을 리스트

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int[] temp = new int[6]; // 주사위 숫자 저장
			for (int j = 0; j < 6; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			dices.add(temp); // 주사위 정보 리스트에 저장
		}

		play(); // 첫번째 주사위 놓기
		System.out.println(res);
	}

	private static void play() {

		for (int i = 0; i < num; i++) { // 해당 인덱스에 해당하는 번호를 천장으로 두자
			sum = findMax(i); // 천장, 바닥 빼고 기둥에서 최대값 저장
			dump(dices.get(0)[i], 1);
			res = res < sum ? sum : res;
		}
	}

	private static void dump(int now, int where) {
		if (where == N) // 다 쌓으면 리턴
			return;

		int[] temp = dices.get(where).clone(); // where번째 주사위 정보 불러오기
		int nextWhere = 0; // 현재 쌓을 주사위의 천장

		for (int i = 0; i < num; i++) {
			if (temp[i] == now) { // 이전 주사위의 천장과 같은 인덱스 찾기(바닥 두기)
				if (i == 0 || i == num - 1) { // 위 아래일 경우
					nextWhere = i == 0 ? temp[num - 1] : temp[0]; // 0이면 num-1을 천장으로, 아니면 반대
					temp[0] = 0;
					temp[num - 1] = 0;
				} else {
					int top = i + 2 <= 4 ? i + 2 : (i + 2) % 5 + 1; // 천장으로 둘 친구 정하기
					nextWhere = temp[top]; // 천장 두기
					temp[i] = 0;
					temp[top] = 0;
				}
				break;
			}
		}

		// 기둥에서 최대 값 찾기
		int max = 0;
		for (int i = 0; i < num; i++) {
			max = max < temp[i] ? temp[i] : max;
		}

		sum += max; // 기둥 최대 값 더하고
		dump(nextWhere, where + 1); // 천장에 해당하는 숫자를 where + 1번째가 찾아서 쌓을 예정
	}

	private static int findMax(int i) {

		int[] temp = dices.get(0).clone(); // 첫번째 주사위

		if (i == 0 || i == num - 1) { // 쌓는 기준이 위, 아래일 경우
			temp[0] = 0;
			temp[num - 1] = 0;
		} else { // 나머지 친구들
			temp[i] = 0;
			int top = i + 2 <= 4 ? i + 2 : (i + 2) % 5 + 1;
			temp[top] = 0;
		}

		// 기둥에서 최대 값 찾기
		int max = 0;
		for (int idx = 0; idx < num; idx++) {
			max = max < temp[idx] ? temp[idx] : max;
		}

		return max;
	}
}