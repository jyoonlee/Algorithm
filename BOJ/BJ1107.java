import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
	static StringTokenizer st;
	static boolean[] number = new boolean[10];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int init = 100;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int ans = Math.abs(N - init);

		// 고장난 버튼이 있을 경우에만 
		if (M > 0) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				int crashed = Integer.parseInt(st.nextToken());
				number[crashed] = true;
			}
		}

		// 0부터 50만으로 올라가는 경우도 있지만 
		// 100만에서 50으로 내려가는 경우도 있다 
		for (int i = 0; i <= 1000000; i++) {

			int cnt = canEnter(i);
			if (cnt > 0) {
				ans = Math.min(ans, Math.abs(i - N) + cnt);
			}
		}

		System.out.println(ans);

	}

	private static int canEnter(int i) {

		// 입력 값이 0일 때 
		if (i == 0) {
			if (number[i]) // 0이 고장났다면 
				return 0;
			else
				return 1; // 0 사용이 가능하다면
		}

		int length = 0;
		while (i > 0) {

			int now = i % 10;

			if (number[now])
				return 0;

			length++;
			i /= 10;
		}

		return length;
	}
}
