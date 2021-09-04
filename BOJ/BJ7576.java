import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] check;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, res = -1;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 맵 정보 저장

		// 인풋 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) // 초기에 토마토를 익게 할 수 있는 좌표 큐에 저장 (동시에 퍼뜨려야 함)
					queue.offer(new int[] { i, j });
			}
		}

		bfs();
		
		for (int i = 0; i < N; i++) { // 안익은게 하나라도 있다면?
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					res = -1; // 결과값 변경
					break;
				}
			}
		}
		
		System.out.println(res);
	}

	// 너비 우선 탐색
	private static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			res++;

			while (size-- > 0) {

				int[] now = queue.poll();
				for (int idx = 0; idx < 4; idx++) { // 델타 탐색
					int ni = now[0] + dy[idx];
					int nj = now[1] + dx[idx];
					
					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
						map[ni][nj] = 1;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}
}
