import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13549 {
	static StringTokenizer st;
	static int N, K;
	static int[] parents;
	static Queue<int[]> queue;
	static boolean[] check = new boolean[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();

		queue.add(new int[] { N, 0 });
		check[N] = true;
		bfs();
	}

	private static void bfs() {

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (now[0] == K) {
				System.out.println(now[1]);
				return;
			}

			if (now[0] * 2 <= 100000 && !check[now[0] * 2]) { // 시간이 더 빠르니 우선으로 추가 시키기 
				queue.offer(new int[] { now[0] * 2, now[1] }); 
				check[now[0] * 2] = true;
			}

			if (now[0] - 1 >= 0 && !check[now[0] - 1]) {
				queue.offer(new int[] { now[0] - 1, now[1] + 1 });
				check[now[0] - 1] = true;
			}

			if (now[0] + 1 <= 100000 && !check[now[0] + 1]) {
				queue.offer(new int[] { now[0] + 1, now[1] + 1 });
				check[now[0] + 1] = true;
			}
		}

	}
}
