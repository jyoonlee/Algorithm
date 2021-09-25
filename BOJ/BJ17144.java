import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17144 {
	static StringTokenizer st;
	static int R, C, T, time;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static List<int[]> loc;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		loc = new ArrayList<>();

		// 맵 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					loc.add(new int[] { i, j }); // 공기 청정기 위치
				}
			}
		}

		play(); // 시뮬레이션 시작
	}

	private static void play() {

		while (time < T + 1) { // 정해진 시간 동안 공기청정기 돌리기

			time++;

			if (time == T + 1)
				break;

			int[][] temp = new int[R][C]; // 확산된 먼지를 저장할 임시 배열

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) { // 먼지가 발견되었다면

						int cnt = 0;

						// 4방 탐색으로 먼지 확산
						for (int idx = 0; idx < 4; idx++) {
							int ni = i + dy[idx];
							int nj = j + dx[idx];

							if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
								temp[ni][nj] += map[i][j] / 5; // 확산될 먼지는 임시 배열에 모아준다.
								cnt++; // 확산 방향 카운팅
							}
						}
						map[i][j] -= (map[i][j] / 5) * cnt; // 확산된 먼지만큼 줄여준다.
					}
				}
			}

			merge(map, temp); // 먼지 합치기 
			turnOn(); // 공기 정청기 가동

		}
		countDust(); // 먼지 세기 

	}

	private static void merge(int[][] map, int[][] temp) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	// 공기 청정기 돌리기 
	private static void turnOn() {

		int locTop = loc.get(0)[0];
		int locBottom = loc.get(1)[0];

		// 위
		for (int i = locTop - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];

		for (int i = 0; i < C - 1; i++)
			map[0][i] = map[0][i + 1];

		for (int i = 0; i < locTop; i++)
			map[i][C - 1] = map[i + 1][C - 1];

		for (int i = C - 1; i > 1; i--) {
			map[locTop][i] = map[locTop][i - 1];
		}

		map[locTop][1] = 0; // 공기 청정기 바로 옆 자리

		// 아래
		for (int i = locBottom + 1; i < R - 1; i++)
			map[i][0] = map[i + 1][0];

		for (int i = 0; i < C - 1; i++)
			map[R - 1][i] = map[R - 1][i + 1];

		for (int i = R - 1; i > locBottom; i--)
			map[i][C - 1] = map[i - 1][C - 1];

		for (int i = C - 1; i > 1; i--) {
			map[locBottom][i] = map[locBottom][i - 1];
		}

		map[locBottom][1] = 0; // 공기 청정기 바로 옆 자리
	}

	private static void countDust() {

		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					res += map[i][j];
			}
		}

		System.out.println(res);
	}
}
