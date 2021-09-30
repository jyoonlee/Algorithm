import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4485_dijkstra {
	static StringTokenizer st;
	static int N, init, idx = 1;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			N = Integer.parseInt(in.readLine());

			if (N == 0) // 종료 조건
				break;

			// 맵 입력
			map = new int[N][N]; 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			init = map[0][0]; // 시작 위치의 몬스터 값 
			leastCost(); // 탐색
			idx++;
		}
	}

	private static void leastCost() {

		int[][] cost = new int[N][N]; // 모든 비용 무한대로 초기화
		for (int i = 0; i < cost.length; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		// 현재까지의 비용 기준으로 우선순위 큐 
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		// 시작 위치 값 
		queue.offer(new int[] { 0, 0, init });
		cost[0][0] = init;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {

					// 비용 값 갱신
					if (cost[ni][nj] > now[2] + map[ni][nj]) {
						cost[ni][nj] = now[2] + map[ni][nj];
						queue.offer(new int[] { ni, nj, now[2] + map[ni][nj] }); // 큐에 추가
					}
				}
			}
		}

		System.out.printf("Problem %d: %d\n", idx, cost[N - 1][N - 1]);
	}
}
