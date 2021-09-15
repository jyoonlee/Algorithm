
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리제이션 피보나치

public class BJ1003 {
	static StringTokenizer st;
	static int[] zero = new int[41];
	static int[] one = new int[41];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(in.readLine());
			for (int j = 2; j <= N; j++) {
				zero[j] = zero[j - 2] + zero[j - 1];
				one[j] = one[j - 2] + one[j - 1];
			}

			System.out.println(zero[N] + " " + one[N]);
		}
	}
}
