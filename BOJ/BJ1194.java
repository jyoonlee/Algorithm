import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다 가자 
// 각각 어떤 키를 가지고 지나쳤는 지가 중요한 게 아님, 지나칠 당시 어떤 열쇠들을 가지고 있는 지가 중요
// 열쇠 요소가 아닌 가지고 있는 열쇠 리스트로 방문체크하기

public class BJ1194 {
	static StringTokenizer st;
	static char[][] map;
	static boolean[][][] check;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M;
	static Local me;
	static int res = -1;

	static class Local {
		int i, j, cnt;
		int key = 0;

		public Local(int i, int j, int cnt, int key) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == '0') {
					me = new Local(i, j, 0, 0);
					map[i][j] = '.';
				}
			}
		}

		bfs();
		System.out.println(res);
	}

	private static void bfs() {

		// 초기 세팅
		Queue<Local> queue = new LinkedList<>();
		check = new boolean[N][M][1 << 7]; // 어느 키를 가지고 방문했는 지
		queue.offer(me);
		check[me.i][me.j][0] = true;

		while (!queue.isEmpty()) {

			Local now = queue.poll();

			// 탈출 성공
			if (map[now.i][now.j] == '1') {
				res = now.cnt;
				return;
			}

			// 4방 탐색
			for (int idx = 0; idx < 4; idx++) {

				int ni = now.i + dy[idx];
				int nj = now.j + dx[idx];

				if (isPossible(ni, nj)) {

					// 누구나 지나갈 수 있는 길인 경우 (그냥 통로, 도착지)
					if (map[ni][nj] == '.' || map[ni][nj] == '1') {

						if (!check[ni][nj][now.key]) { // 키가 있다면 어느 키 들고 왔나?
							check[ni][nj][now.key] = true;
							queue.offer(new Local(ni, nj, now.cnt + 1, now.key)); // 큐에 추가
						}
					}

					// 키나 문을 만났을 때
					else if (map[ni][nj] != '#') {

						char find = map[ni][nj];

						if (Character.isUpperCase(find)) { // 대문자라면 문
							int number = find - 'A' + 1;

							if ((now.key & 1 << number) != 0) { // 문에 대한 키를 가지고 있다면?

								if (!check[ni][nj][now.key]) { // 키가 있다면 어느 키 들고 왔나?
									check[ni][nj][now.key] = true;
									queue.offer(new Local(ni, nj, now.cnt + 1, now.key)); // 큐에 추가
								}
							}

						} else { // 키를 획득했을 때
							int number = find - 'a' + 1;

							if (!check[ni][nj][now.key]) { // 키가 있다면 어느 키 들고왔나?
								check[ni][nj][now.key] = true;
								queue.offer(new Local(ni, nj, now.cnt + 1, now.key | (1 << number))); // 큐에 추가
							}
						}
					}
				}
			}
		}
	}

	private static boolean isPossible(int i, int j) {

		if (i >= 0 && i < N && j >= 0 && j < M && map[i][j] != '#')
			return true;
		else
			return false;
	}
}
