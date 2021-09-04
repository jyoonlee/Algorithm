package com.ssafy.algorithm.JUNGNC;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class JUNG1828 {
	static StringTokenizer st;
	static int N, R, C;
	static int[] dy = { 0, 0, 1, 1 };
	static int[] dx = { 0, 1, 0, 1 };
	static int[][] map;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> list = new ArrayList<>(); // 화학물질을 담을 리스트

		N = Integer.parseInt(in.readLine());
		int cnt = 1; // 냉장고 개수 

		for (int i = 0; i < N; i++) { // 리스트에 화학물질 정보 담기 
			st = new StringTokenizer(in.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 최저 온도 기준으로 오름차순 정렬 
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		// 첫번째 시작 인자 저장 
		int end = list.get(0)[1];

		// 화학물질 간 비교 
		for (int i = 1; i < list.size(); i++) {

			if (end < list.get(i)[0]) { // 최대 보관 온도 보다 새로운 화학물질 최저 온도가 높을 경우 냉장고 추가 
				end = list.get(i)[1];
				cnt++;
			} else if (end > list.get(i)[1]) // 새로운 화학 물질의 최대 온도가 더 낮을 경우 갱신
				end = list.get(i)[1];
		}

		System.out.println(cnt);
	}
}
