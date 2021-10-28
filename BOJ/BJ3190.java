import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 - 뱀(골드 5)
// https://www.acmicpc.net/problem/3190

public class BJ3190 {
	static int N, K, L;
	static int[][] map;
	static Queue<String[]> order;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static List<int[]> snake;
	static int time = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		order = new LinkedList<>(); // 명령 순서 처리
		map = new int[N][N]; // 전체 맵 
		snake = new ArrayList<>(); // 뱀의 몸통 정보 담을 배열 
		snake.add(new int[] { 0, 0 }); // 초기 위치 

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			map[y][x] = 1; // 먹이 표시
		}

		L = Integer.parseInt(in.readLine());

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			order.offer(new String[] { st.nextToken(), st.nextToken() }); // 큐에 명령 저장 
		}

		game();
		System.out.println(time);
	}

	private static void game() {

		int direction = 0;
		int ny = 0;
		int nx = 0;

		while (true) {

			// 큐가 비어있지 않을 때 & 명령 시간이 되었을 때 
			if (!order.isEmpty() && Integer.parseInt(order.peek()[0]) == time) {
				String[] now = order.poll();

				// 방향 전환해주기 
				if (now[1].equals("D"))
					direction = (direction + 1) % 4; // 오른쪽으로 90도
				else
					direction = direction - 1 < 0 ? 3 : direction - 1; // 왼쪽으로 90도
			}

			// 방향 전환
			ny += dy[direction];
			nx += dx[direction];
			time++;

			if (isPossible(ny, nx)) { // 뱀의 게임이 끝났는 지 판별

				if (map[ny][nx] != 1) {
					snake.add(new int[] { ny, nx });
					snake.remove(0); // 먹이를 먹지 못했다면 꼬리 자르기 
				} else {
					snake.add(new int[] { ny, nx });
					map[ny][nx] = 0;
				}
			} else
				return;
		}

	}

	private static boolean isPossible(int y, int x) {

		if (y >= 0 && y < N && x >= 0 && x < N) { // 범위 탐색

			for (int i = 0; i < snake.size(); i++) {

				int[] now = snake.get(i); // 새로 갈 위치가 뱀의 몸통 부위와 겹치는 지 판별
				if (y == now[0] && x == now[1])
					return false; // 겹친다면 게임 종료
			}

			return true;
		} else
			return false;
	}
}
