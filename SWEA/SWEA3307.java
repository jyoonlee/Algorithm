import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최장 증가 부분 수열 (LIS)

public class SWEA3307 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(in.readLine());
			int[] input = new int[N];
			int[] res = new int[N];

			// 인풋 값 입력
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				res[i] = 1; // 초기 길이 1로 세팅

				for (int j = 0; j < i; j++) {
					if (input[i] > input[j] && res[i] < res[j] + 1) { // 현재 자신보다 크기가 작고, 이어붙였을 때 유의미하다면
						res[i] = res[j] + 1; // 원소로 포함
					}
				}
				max = max < res[i] ? res[i] : max; // 최대 길이 갱신
			}
			System.out.printf("#%d %d%n", test_case, max);
		}
	}

}
