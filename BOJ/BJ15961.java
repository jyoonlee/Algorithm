import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 슬라이딩 윈도우, 투포인터

public class BJ15961 {
	static StringTokenizer st;
	static int N, D, K, C;
	static int res, rail[], check[];

	// 1. 특정 위치부터 k접시를 연속해서 먹으면 할인
	// 2. 각 고객에게는 초밥 쿠폰 1매 제공, 1번 참여하면 쿠폰 초밥 제공
	// --> 없다면 요리사가 새로 만들어서 제공

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());

		// 입력
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		rail = new int[N];
		check = new int[D + 1];

		for (int i = 0; i < N; i++)
			rail[i] = Integer.parseInt(in.readLine());

		eat();

	}

	private static void eat() {

		// 첫 윈도우 계산
		int now = 0;
		for (int i = 0; i < K; i++) {
			if (check[rail[i]] == 0) // 안먹었던 거라면
				now++; // 증가

			check[rail[i]]++; // 먹었다고 체크
		}

		// 밀면서 지나가기
		res = now;
		for (int i = 1; i < N; i++) {
			if (res <= now) { // 갱신
				if (check[C] == 0) // 만약 쿠폰을 쓸 수 있다
					res = now + 1;
				else
					res = now; // 쿠폰이 이미 먹은 음식에 포함되어 있음
			}

			int before = i - 1; // 제거해야 할 초밥 인덱스
			int after = (i + K - 1) % N; // 새롭게 먹을 초밥 인덱스

			check[rail[before]]--; 
			if (check[rail[before]] == 0) // 제거했을 때 아예 안먹은거라면 값에서도 -
				now--;

			if (check[rail[after]] == 0) // 앞으로 먹을 것이 안먹었던거라면 값 + 
				now++;
			check[rail[after]]++; // 먹었다고 체크
		}

		System.out.println(res);
	}
}
