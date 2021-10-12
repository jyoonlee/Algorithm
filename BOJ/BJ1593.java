import java.io.*;
import java.util.*;

// 슬라이딩 윈도우 
public class BJ1593 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int g = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		char[] W = in.readLine().toCharArray();
		char[] S = in.readLine().toCharArray();

		int[] word = new int[52];
		int[] check = new int[52];

		int res = 0;

		// 초기 윈도우 세팅
		for (int i = 0; i < W.length; i++) {

			int wValue = W[i] >= 'a' ? W[i] - 'a' : W[i] - 'A' + 26;
			int sValue = S[i] >= 'a' ? S[i] - 'a' : S[i] - 'A' + 26;

			word[wValue]++;
			check[sValue]++;
		}

		// 비교
		if (isSame(check, word))
			res++;

		// 밀면서 나아가기
		int idx = 0;
		for (int i = W.length; i < S.length; i++) {

			int head = S[idx] >= 'a' ? S[idx] - 'a' : S[idx] - 'A' + 26;
			int tail = S[i] >= 'a' ? S[i] - 'a' : S[i] - 'A' + 26;

			check[head]--;
			check[tail]++;

			if (isSame(check, word))
				res++;

			idx++;
		}

		System.out.println(res);
	}

	private static boolean isSame(int[] check, int[] word) {

		for (int i = 0; i < check.length; i++) {
			if (check[i] != word[i])
				return false;
		}
		return true;
	}
}
