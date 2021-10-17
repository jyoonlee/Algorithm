import java.io.*;
import java.util.*;

// LCA 알고리즘 (최단 공통 부모 찾기)
public class BJ3584 {

	static int T, N;
	static int[] parents;
	static int[] depth;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			N = Integer.parseInt(in.readLine());
			parents = new int[N + 1];
			depth = new int[N + 1];
			adjList = new ArrayList[N + 1];

			for (int i = 0; i < N + 1; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from].add(to);
				// adjList[to].add(from);

				parents[to] = from;
			}

			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int root = 0;
			for (int i = 1; i < N + 1; i++) {
				if (parents[i] == 0) {
					root = i;
					break;
				}
			}

			dfs(root, 0);
			lca(a, b);
		}
	}

	static public void dfs(int now, int depthValue) {
		depth[now] = depthValue;

		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);

			dfs(next, depthValue + 1);
		}
	}

	static public void lca(int a, int b) {

		while (depth[a] != depth[b]) {

			if (depth[a] > depth[b])
				a = parents[a];
			else
				b = parents[b];
		}

		while (a != b) {
			a = parents[a];
			b = parents[b];
		}

		System.out.println(a);
	}
}
