import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] houses = new int[N][3];
		int[][] D = new int[N][3];
		int res = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
		}

		D[0][0] = houses[0][0];
		D[0][1] = houses[0][1];
		D[0][2] = houses[0][2];

		for (int i = 1; i < N; i++) {
			D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + houses[i][0];
			D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + houses[i][1];
			D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + houses[i][2];
		}

		res = Math.min(D[N - 1][0], D[N - 1][1]);
		res = Math.min(res, D[N - 1][2]);
		System.out.println(res);

	}
}
