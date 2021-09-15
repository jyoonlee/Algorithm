import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1463 {
	static StringTokenizer st;
	static int[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		D = new int[N + 1];

		for (int i = 2; i <= N; i++) {

			int temp = Integer.MAX_VALUE;
			if (i % 3 == 0)
				temp = Math.min(temp, D[i / 3]);
			if (i % 2 == 0)
				temp = Math.min(temp, D[i / 2]);
			D[i] = Math.min(temp, D[i - 1]) + 1;

		}

		System.out.println(D[N]);
	}
}
