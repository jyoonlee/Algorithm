import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236 {
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static Shark me;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static class Shark { // 아기상어 주인공 객체
		int y;
		int x;
		int size;
		int eat;

		public Shark(int y, int x, int size, int eat) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.eat = eat;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int time = 0;

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					me = new Shark(i, j, 2, 0);
					map[i][j] = 0; // 아기 상어 위치 0으로 초기화
				}
			}
		}

		while (true) {
			int temp = bfs(); // 먹으러간 시간 반환, 없다면 -1 반환

			if (temp == -1)
				break;
			else
				time += temp;
		}

		System.out.println(time);
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] check = new boolean[N][N];

		queue.offer(new int[] { me.y, me.x, 0 }); // 아기 상어 위치
		check[me.y][me.x] = true; // 방문 체크

		List<int[]> fishes = new ArrayList<>(); // 먹을 물고기 배열
		int minDistance = Integer.MAX_VALUE; // 최단 거리

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (now[2] == minDistance) // 최단 거리를 마주쳤다면, 이미 먹을 물고기를 배열 안에 넣은 상태, break
				break;

			for (int i = 0; i < 4; i++) {
				int ni = now[0] + dy[i];
				int nj = now[1] + dx[i];

				// 지나갈 수 있다면?
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj] && map[ni][nj] <= me.size) {
					check[ni][nj] = true;
					queue.offer(new int[] { ni, nj, now[2] + 1 }); // queue에 저장

					if (map[ni][nj] > 0 && map[ni][nj] < me.size) { // 만약 먹을 수 있다면
						minDistance = now[2] + 1;
						fishes.add(new int[] { ni, nj, now[2] + 1 }); // 먹을 수 있는 물고기로 추가
					}
				}
			}
		}

		if (fishes.size() == 0) // 먹을 수 없다면 -1 반환
			return -1;

		Collections.sort(fishes, new Comparator<int[]>() { // 행, 열 기준으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff1 = o1[0] - o2[0];
				int diff2 = o2[1] - o2[1];
				return diff1 == 0 ? diff2 : diff1;
			}
		});

		// 물고기 먹기
		int[] nowFish = fishes.get(0);

		me.y = nowFish[0];
		me.x = nowFish[1];
		map[me.y][me.x] = 0;
		me.eat += 1;

		// 물고기 크기 키우기
		if (me.eat == me.size) {
			me.eat = 0;
			me.size += 1;
		}

		return nowFish[2]; // 먹을때까지 걸리는 시간 반환
	}
}