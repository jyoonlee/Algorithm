import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기 
// 1. 섬 마킹 하기 
// 2. BFS로 탐색하기 (범위 확인!) 

public class BJ2146 {
	static StringTokenizer st;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 섬이라면 일단 -1로 마킹
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}

		// 섬 마킹하기 
		int mark = 1; // 첫번째 섬부터 시작 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) { // 섬 발견했다면?
					map[i][j] = mark; // 마킹 해주기 
					marking(i, j, mark); // bfs로 마킹 
					mark++; // 섬 번호 증가
				}
			}
		}

		// 다리 거리 비교하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) // 섬이라면? 
					res = Math.min(res, find(i, j, map[i][j], -1)); // 최소 다리 길이를 찾는다
			}
		}
		
		System.out.println(res); // 결과
	}

	// 섬 번호 마킹하기 
	private static void marking(int i, int j, int mark) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			// 4방 탐색
			for (int idx = 0; idx < 4; idx++) {

				int ni = now[0] + dy[idx];
				int nj = now[1] + dx[idx];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == -1) {
					queue.offer(new int[] { ni, nj });
					map[ni][nj] = mark; // 섬 번호 마킹
				}
			}
		}
	}

	// 다리 만들기
	private static int find(int i, int j, int mark, int cnt) {

		// 방문 체크
		boolean[][] check = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { i, j, mark, cnt});
		check[i][j] = true;

		int min = Integer.MAX_VALUE; // 현재 육지 위치에서 놓을 수 있는 다리 위치 찾기 위해

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			
			if(now[3] > min) // 만약 다리 길이가 더 길어질 경우에는 따질 필요가 없음 (메모리 사용량 50% 감축)
				continue;

			// 다리 놓을 수 있다면? 최소값으로 갱신
			if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] != mark) {
				min = Math.min(now[3], min);
			}

			// 4방 탐색
			for (int idx = 0; idx < 4; idx++) {

				int ni = now[0] + dy[idx];
				int nj = now[1] + dx[idx];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj] && map[ni][nj] != mark) {
					check[ni][nj] = true;
					queue.offer(new int[] { ni, nj, mark, now[3] + 1 }); // 정보 넘겨주기
				}
			}
		}

		return min; // 다리 길이 최소값 반환
	}
}
