import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12851
// BFS 기본 

public class Bj12851 {
	static StringTokenizer st;
	static int N, K, res, min = Integer.MAX_VALUE;
	static final int MAX = 100001;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(min);
		System.out.println(res);
	}

	private static void bfs() {

		Queue<int[]> queue = new LinkedList<>();
		boolean[] check = new boolean[MAX];

		queue.offer(new int[] { N, 0 });
		check[N] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			check[now[0]] = true;

			if (now[0] == K) {
				if (min > now[1]) {
					min = now[1];
					res++;
				}
				else if (min == now[1])
					res++;
				continue;
			}

			if (isPossible(now[0] + 1, check)) {
				queue.offer(new int[] { now[0] + 1, now[1] + 1 });
			}

			if (isPossible(now[0] - 1, check)) {
				queue.offer(new int[] { now[0] - 1, now[1] + 1 });
			}

			if (isPossible(now[0] * 2, check)) {
				queue.offer(new int[] { now[0] * 2, now[1] + 1 });
			}

		}

	}

	private static boolean isPossible(int N, boolean[] check) {

		if (N >= 0 && N < 100001 && !check[N])
			return true;

		return false;
	}
}
