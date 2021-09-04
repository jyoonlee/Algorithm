package com.ssafy.algorithm.SWEA;

//10 1238099084
//16 4100112380990844
//26 12380990844100112380990844
//42 123809908444100112380990844100112380990844
//55 1238099084441001123809908441001321238099084432180990844
//60 123809908444100145351123809908441001321238099084432180990844
//71 12380990844410013218099084441001123809908441001321238099084432180990844
//99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844
//82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844
//58 0899809812380990844100132123809908441238099084432180990844

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA1234 {
	static final int T = 10;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 0; test_case < T; test_case++) {

			String result = "";
			int N = sc.nextInt();
			List<Character> arr = new ArrayList<>();

			String S = sc.next();

			for (int i = 0; i < N; i++) {
				arr.add(S.charAt(i));
			}

			for (int i = 0; i < arr.size() - 1; i++) {
				if (arr.get(i) == arr.get(i + 1)) {
					arr.remove(i);
					arr.remove(i);
					if (i >= 2)
						i -= 2;
					else
						i = -1;
				}
			}

			for (int i = 0; i < arr.size(); i++) {
				result += arr.get(i);
			}

			System.out.printf("#%d %s%n", test_case + 1, result);
		}

	}

}
