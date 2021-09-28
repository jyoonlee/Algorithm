import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11041 {
	static StringTokenizer st;
	static final int MOD = 1_000_000_007;
	static long[] factorial;
	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		factorial = new long[N + 2]; // Factorial 구해두기
		factorial[1] = 1;

		for (int i = 2; i <= N; i++) {
			factorial[i] = (factorial[i - 1] * i) % MOD;
		}

		long res = nCr(K);

		System.out.println(res);
	}

	private static long nCr(int k) {

		if (k == 0 || N == 1 && k == 1)
			return 1;

		long l1 = factorial[N];
		long l2 = pow(factorial[N - k], MOD - 2);
		long l3 = pow(factorial[k], MOD - 2);
		
		return ((l1 * l2) % MOD * (l3) % MOD) % MOD;
	}

	static long pow(long a, int b) {
		if (b == 1)
			return a;

		long half = pow(a, b / 2);
		if (b % 2 == 0) {
			return (half * half) % MOD;

		} else
			return ((half * half) % MOD * (a) % MOD) % MOD;
	}
}
