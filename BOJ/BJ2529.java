import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2529 {
	static StringTokenizer st;
	static int N;
	static String max = "0", min = "" + Long.MAX_VALUE; // 입력 값 초과 대비
	static String[] condition;
	static int[] values;
	static boolean[] check = new boolean[10];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		values = new int[N + 1];
		condition = in.readLine().split(" ");

		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int cnt) {
		if (cnt == N + 1) { // 순열 완성
			// 부등호 비교
			for (int i = 0; i < condition.length; i++) {
				switch (condition[i]) {
				case "<":
					if (!(values[i] < values[i + 1]))
						return;
					break;
				case ">":
					if (!(values[i] > values[i + 1]))
						return;
					break;
				}
			}

			String s = "";
			for (int i = 0; i < values.length; i++) {
				s += values[i];
			}

			max = Long.parseLong(max) < Long.parseLong(s) ? s : max; // 결과 값 저장
			min = Long.parseLong(min) > Long.parseLong(s) ? s : min; // 결과 값 저장
			return;
		}

		// 순열
		for (int i = 0; i < 10; i++) {
			if (check[i])
				continue;

			values[cnt] = i;
			check[i] = true;
			permutation(cnt + 1);
			check[i] = false;
		}

	}
}
