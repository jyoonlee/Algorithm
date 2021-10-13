
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2579 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[][] check = new int[N + 3][2];

		if (N == 1) { // 계단이 하나일 때
			System.out.println(Integer.parseInt(in.readLine()));
		} else {

			check[1][0] = Integer.parseInt(in.readLine()); // 첫번째 계단일 때 (한 칸)

			int second = Integer.parseInt(in.readLine()); // 두번째 계단일 때
			check[2][0] = check[1][0] + second; // 한 칸 올라온 것
			check[2][1] = second; // 두 칸 올라온 것 

			// 메모제이션
			for (int i = 3; i < N + 1; i++) {
				int now = Integer.parseInt(in.readLine());

				check[i][1] = Math.max(check[i - 2][0], check[i - 2][1]) + now;
				check[i][0] = check[i - 1][1] + now;
			}

			System.out.println(Math.max(check[N][0], check[N][1]));
		}

	}
}