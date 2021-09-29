import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11726 {
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		int[] check = new int[N + 1];

		check[1] = 1;
		check[2] = 2;

		// 메모제이션
		for (int i = 3; i < N + 1; i++) {
			check[i] = (check[i - 1] + check[i - 2]) % 10007;
		}

		System.out.println(check[N]);
	}
}