package com.ssafy.algorithm.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		List<String> list = new ArrayList<>();
		String temp = "";
		boolean flag = false;

		// 리스트에 String으로 넣어주기
		for (int i = 0; i < input.length(); i++) {
			// 태그 부분
			if (input.charAt(i) == '<') { // 괄호 발견
				if (flag) {
					list.add(temp);
					temp = "";
					flag = false;
				}

				while (input.charAt(i) != '>') { // 괄호 끝
					temp += input.charAt(i);
					i++;
				}

				temp += '>';
				list.add(temp); // 태그 추가
				temp = "";
				continue;

			} else
				flag = true;

			// 일반 단어
			if (input.charAt(i) == ' ' || (i == input.length() - 1)) { // 단어 추가 부분
				if (i == input.length() - 1)
					temp += input.charAt(i);
				list.add(temp); // 일반 단어 추가
				temp = "";
				continue;
			}
			temp += input.charAt(i);
		}

		// 단어 뒤집기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).startsWith("<")) {
				System.out.print(list.get(i));
				continue;
			} else {
				temp = "";
				for (int j = list.get(i).length() - 1; j >= 0; j--) {
					temp += list.get(i).charAt(j);
				}

				if (i == list.size() - 1 || list.get(i + 1).startsWith("<"))
					System.out.print(temp);
				else
					System.out.print(temp + " ");
			}
		}
	}
}
