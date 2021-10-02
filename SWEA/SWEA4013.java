import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 자석 문제

public class SWEA4013 {
	static StringTokenizer st;
	static int K;
	static int[][] map;
	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case < T + 1; test_case++) {

			K = Integer.parseInt(in.readLine());
			map = new int[4][8];

			// 입력
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// 회전 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());

				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				// 인접 리스트 만들기
				adjList = new ArrayList[4];

				for (int j = 0; j < 4; j++) {
					adjList[j] = new ArrayList<>();
				}

				check(); // 인접 리스트 주입
				visited = new boolean[4];
				visited[num] = true;
				play(num, dir); // 탐색 및 회전

			}

			// 결과 계산
			int res = 0;
			for (int i = 0; i < 4; i++) {
				if (map[i][0] == 1)
					res += (1 << i);
			}

			System.out.printf("#%d %d\n", test_case, res);
		}
	}

	private static void check() {

		// 오른쪽 영향
		for (int i = 0; i < 3; i++) {
			if (map[i][2] != map[i + 1][6])
				adjList[i].add(i + 1);
		}

		// 왼쪽 영향
		for (int i = 3; i > 0; i--) {
			if (map[i][6] != map[i - 1][2])
				adjList[i].add(i - 1);
		}
	}

	private static void turn(int i, int num) {

		// 회전
		if (i == 1)
			clockwise(num);
		else
			counterClockwise(num);

	}

	private static void clockwise(int num) {

		// 시계방향
		int last = map[num][7];
		for (int i = 7; i > 0; i--) {
			map[num][i] = map[num][i - 1];
		}
		map[num][0] = last;
	}

	private static void counterClockwise(int num) {

		// 반시계방향
		int first = map[num][0];
		for (int i = 0; i < 7; i++) {
			map[num][i] = map[num][i + 1];
		}
		map[num][7] = first;
	}

	private static void play(int num, int dir) {

		List<Integer> now = adjList[num]; // 현재 자석위치의 인접 리스트
		turn(dir, num); // 돌리기

		for (int i = 0; i < now.size(); i++) { // 영향 받는 애들 순으로

			if (visited[now.get(i)]) // 이미 돌렸다면
				continue;

			visited[now.get(i)] = true; // 방문 체크
			play(now.get(i), dir * -1); // 반대 방향으로 돌려주기 및 탐색
		}
	}
}
