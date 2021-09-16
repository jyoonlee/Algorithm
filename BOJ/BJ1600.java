import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1600 {
	static StringTokenizer st;
	static int K, W, H;
	static int[][] map;
	static int[] hy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		// 맵 입력
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 너비 탐색
		bfs();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] check = new boolean[H][W][K + 1]; // 몇번 점프해서 해당 위치에 방문했는 지까지 체크 
		queue.offer(new int[] { 0, 0, 0, 0 }); // 가로, 세로, 이동횟수, 점프한 횟수 
		check[0][0][0] = true; // 초기 상태 체크 
		int res = -1; // 결과값 

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (now[0] == H - 1 && now[1] == W - 1) { // 끝까지 다 갔을 경우 
				res = now[2]; // count 저장 
				break;
			}

			for (int i = 0; i < 4; i++) { // 4방 탐색 먼저 진행 
				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				if (ni >= 0 && ni < H && nj >= 0 && nj < W && !check[ni][nj][now[3]] && map[ni][nj] == 0) { // 점프를 하지 않으니 now[3]
					check[ni][nj][now[3]] = true; // 방문체크 
					queue.offer(new int[] { ni, nj, now[2] + 1, now[3] }); // count 값만 올려준다. 점프 X 
				}
			}

			if (now[3] < K) { // 점프 할 수 있다면? 
				for (int i = 0; i < 8; i++) { // 8방 탐색 
					int ni = now[0] + hy[i];
					int nj = now[1] + hx[i];

					if (ni >= 0 && ni < H && nj >= 0 && nj < W && !check[ni][nj][now[3] + 1] && map[ni][nj] == 0) { // 점프 한적 있는 지 확인 
						check[ni][nj][now[3] + 1] = true; // 안했다면 점프한 기록으로 방문 
						queue.offer(new int[] { ni, nj, now[2] + 1, now[3] + 1 }); // 점프, 카운팅 더하기 
					}
				}
			}

		}

		System.out.println(res); // 끝까지 가지 못했다면 res 값은 갱신되지 않아 -1, 갔다면 카운트 값 출력 
	}

}
