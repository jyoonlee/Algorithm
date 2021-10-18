import java.io.*;
import java.util.*;

public class BJ5568 {
	static int N, K;
	static int[] card;
	static int[] value;
	static Set<Integer> res = new HashSet<>();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		card = new int[N];
		value = new int[K];

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(in.readLine());
		}

		permutation(0, 0);
		System.out.println(res.size());
	}

	private static void permutation(int cnt, int flag) {

		if (cnt == K) {
			int now = 0;
			int temp = 1;

			String s = "";

			for (int i = 0; i < K; i++)
				s += value[i];

			for (int i = s.length() - 1; i >= 0; i--) {

				now += (s.charAt(i) - '0') * temp;
				temp *= 10;

			}

			res.add(now);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			value[cnt] = card[i];

			permutation(cnt + 1, flag | 1 << i);
		}
	}

}
