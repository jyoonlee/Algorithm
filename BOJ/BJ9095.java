import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int idx = 0; idx < T; idx++) {

			int N = Integer.parseInt(in.readLine());
			int[] check = new int[N + 3];

			check[1] = 1;
			check[2] = 2;
			check[3] = 4;
			// 1 1 1, 1 2, 2 1, 3 

			// 메모제이션
			for (int i = 4; i < N + 1; i++) {
				check[i] = check[i - 3] + check[i - 2] + check[i - 1];
			}
			System.out.println(check[N]);
		}
	}
}