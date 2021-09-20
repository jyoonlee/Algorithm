import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9205 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 0; test_case < T; test_case++) {

			int N = Integer.parseInt(in.readLine());
			int[][] adjMatrix = new int[N + 2][N + 2];
			int[][] D = new int[N + 2][N + 2];
			List<int[]> input = new ArrayList<>();

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(in.readLine());
				input.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					int[] from = input.get(i);
					int[] to = input.get(j);
					int distance = Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);

					adjMatrix[i][j] = distance;

					if (distance <= 1000)
						D[i][j] = 1;

				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {

						if (D[i][k] == 1 && D[k][j] == 1)
							D[i][j] = 1;
					}
				}
			}

			System.out.println(D[0][N + 1] == 0 ? "sad" : "happy");
		}

	}
}