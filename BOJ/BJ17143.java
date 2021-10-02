import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17143 {
	static StringTokenizer st;
	static int R, C, M;
	static int[][] map;
	static List<Shark> sharkList; // 각각의 상어 정보를 담을 배열 
	static List<Integer> sharkAlive; // 살아있는 상어를 조회할 배열 
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int res;

	// 상어 객체
	static class Shark {
		int num, i, j, speed, direction, size;

		public Shark() {
		};

		public Shark(int num, int i, int j, int speed, int direction, int size) {
			this.num = num;
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharkList = new ArrayList<>(); 
		sharkList.add(new Shark()); // 인덱스 맞춰주기 위해 0번째 상어는 그냥 임의로 입력
		sharkAlive = new ArrayList<>(); 

		map = new int[R][C];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());

			map[r][c] = i;
			sharkAlive.add(i); // 현재 상어 번호 붙이기 
			sharkList.add(new Shark(i, r, c, speed, direction, size)); // 상어 정보 입력
		}

		play();
		System.out.println(res);

	}

	/**
	 * 1. 상어 위치 옮기기 2. 방향 바꿔야하는 지 확인하기 3. 옮긴 위치에서 먹힐 지, 먹을 지 판단하기
	 */

	public static void play() {

		for (int now = 0; now < C; now++) {
			catchShark(now); // 상어 잡기
			moveShark(); // 상어 움직이기 
		}
	}

	public static void catchShark(int now) {

		for (int i = 0; i < R; i++) {
			if (map[i][now] != 0) { // 상어가 있다면
				int sharkNum = map[i][now]; // 상어 번호 얻고
				res += sharkList.get(sharkNum).size; // 상어 사이즈 합해주고
				sharkAlive.remove((Integer) sharkNum); // 상어 죽이기
				map[i][now] = 0; // 흔적 지우기 
				break;
			}
		}
	}

	public static void moveShark() {

		for (int idx = 0; idx < sharkAlive.size(); idx++) { // 살아있는 상어 움직여주기 

			Shark now = sharkList.get(sharkAlive.get(idx)); // 현재 상어 

			int d = now.direction; // 방향 

			int ni = now.i;
			int nj = now.j;

			for (int move = 0; move < now.speed; move++) {

				if (!isPossible(ni, nj, d)) // 가장자리로 갔을 경우 방향 전환 
					d = switchDirection(d);

				ni += dy[d];
				nj += dx[d];
			}

			map[now.i][now.j] = 0; // 흔적 지워주기 (이동했으니)
			// 정보 저장
			now.i = ni;
			now.j = nj;
			now.direction = d;
		}

		// 살아있는 상어들 이동한 위치 찍어주기 
		for (int idx = 0; idx < sharkAlive.size(); idx++) {

			Shark now = sharkList.get(sharkAlive.get(idx));
			int enemy = map[now.i][now.j]; // 만약 이동할 자리에 적이 있다면? 

			if (enemy != 0 && sharkList.get(enemy).size < now.size) { // 사이즈 비교 
				sharkAlive.remove((Integer) enemy); // 적 죽이기 
				map[now.i][now.j] = now.num; // 내가 차지 
				idx--; // 배열에서 객체 하나 없앴으니 for문 계속 돌려주기 위해 idx-- 
			} else if (enemy == 0)
				map[now.i][now.j] = now.num; // 자리에 아무도 없다면 내가 차지
			else {
				sharkAlive.remove((Integer) now.num); // 내가 사이즈 져서 먹혔다면 제거 
				idx--;
			}

		}
	}

	// 위치에 따라 방향 바꿔야하는 지 알려주는 함수
	public static boolean isPossible(int i, int j, int d) {

		if (d == 0 && i == 0)
			return false;
		else if (d == 1 && i == R - 1)
			return false;
		else if (d == 2 && j == C - 1)
			return false;
		else if (d == 3 && j == 0)
			return false;
		else
			return true;
	}

	// 바꿔줄 방향 
	public static int switchDirection(int i) {

		switch (i) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 2;
		}

		return -1;
	}
}
