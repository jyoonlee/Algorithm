import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13913 {
	static StringTokenizer st;
	static int N, K, res = -1;
	static int[] parents;
	static Queue<Integer> queue;
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();

		queue.add(N);
		Arrays.fill(check, -1); // 방문하지 않은 곳 초기화
		check[N] = -2; // end point
		bfs();
	}

	private static void bfs() {

		while (!queue.isEmpty()) {

			int size = queue.size(); // 탐색 횟수 카운팅을 위해 
			res++; // 1초 경과

			while (size-- > 0) {

				int now = queue.poll();

				if (now == K) { // 술래를 찾았다면 
					System.out.println(res);

					if (res != 0) {
						List<Integer> path = new ArrayList<>(); // 경로 구하기
						path.add(now); // 현재 위치 저장 (역순으로 간다)

						int idx = now;
						while (true) {
							idx = check[idx]; // check에는 지나온 경로가 포함되어 있음
							path.add(idx);
							if (check[idx] == -2) // 처음 위치라면 break
								break;
						}

						for (int i = path.size() - 1; i >= 0; i--) // 역순으로 출력
							System.out.print(path.get(i) + " ");
					} else
						System.out.println(N); // 만약 출발점과 도착점이 같다면 하나만 출력 (0초일 경우)

					return; // 종료 
				}

				// 너비 탐색
				if (now * 2 <= 100000 && check[now * 2] == -1) { 
					queue.offer(now * 2);
					check[now * 2] = now;
				}

				if (now - 1 >= 0 && check[now - 1] == -1) {
					queue.offer(now - 1);
					check[now - 1] = now;
				}

				if (now + 1 <= 100000 && check[now + 1] == -1) {
					queue.offer(now + 1);
					check[now + 1] = now;
				}
			}
		}
	}
}
