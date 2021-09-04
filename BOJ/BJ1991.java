package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1991 {
	static StringTokenizer st;
	static List<Character>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		adjList = new ArrayList[N]; // 인접 리스트 만들기

		for (int i = 0; i < N; i++) {
			String[] now = in.readLine().split(" ");

			int idx = now[0].charAt(0) - 'A';
			adjList[idx] = new ArrayList<>();

			adjList[idx].add(now[1].charAt(0));
			adjList[idx].add(now[2].charAt(0));
		}

		preorder('A'); // 전위 
		System.out.println();
		inorder('A'); // 중위
		System.out.println();
		postorder('A'); // 후위
	}

	private static void preorder(char now) {
		
		System.out.print(now); // 출력 후 
		
		for (int i = 0; i < adjList[now - 'A'].size(); i++) { // 깊이 탐색
			char value = adjList[now - 'A'].get(i);
			if (value != '.')
				preorder(value);
		}
	}

	private static void inorder(char now) {
		
		char value = adjList[now - 'A'].get(0); // 좌측 탐색 
		if (value != '.')
			inorder(value);

		System.out.print(now); // 자신 출력

		value = adjList[now - 'A'].get(1); // 우측 탐색
		if (value != '.')
			inorder(value);
	}

	private static void postorder(char now) {
		
		for (int i = 0; i < adjList[now - 'A'].size(); i++) { // 좌 우측 탐색 후 
			char value = adjList[now - 'A'].get(i);
			if (value != '.')
				postorder(value);
		}
		
		System.out.print(now); // 자신 출력
	}
}
