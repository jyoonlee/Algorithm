import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위큐가 관건인 문제 

public class BJ1261 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static class Space implements Comparable<Space> { // 공간에 대한 객체
		int y;
		int x;
		int cnt;

		public Space(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Space o) { // 우선 순위 큐의 기준은 벽을 뿌수는 것의 오름차순
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		dfs();
	}

	private static void dfs() {

		PriorityQueue<Space> queue = new PriorityQueue<>(); // 우선순위 큐 생성
		boolean[][] check = new boolean[N][M];
		check[N - 1][M - 1] = true;
		queue.add(new Space(N - 1, M - 1, 0));
		// 끝 점을 루트 노드로 등록

		while (!queue.isEmpty()) {
			Space now = queue.poll();
			int i = now.y;
			int j = now.x;

			if (now.y == 0 && now.x == 0) { // 위치에 왔을 경우 종료
				System.out.println(now.cnt);
				return;
			}

			for (int idx = 0; idx < 4; idx++) { // 사방 탐색

				int ni = i + dy[idx];
				int nj = j + dx[idx];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !check[ni][nj]) {
					check[ni][nj] = true; // 방문 표시

					// 너비 탐색 진행 
					if (map[ni][nj] == 1)
						queue.offer(new Space(ni, nj, now.cnt + 1));
					else
						queue.offer(new Space(ni, nj, now.cnt));
				}

			}

		}
	}
}
