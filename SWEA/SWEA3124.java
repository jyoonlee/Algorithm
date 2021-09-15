import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA3124 {
	static StringTokenizer st;
	static int T, V, E;
	static boolean[] check;
	static int[] parents;
	static PriorityQueue<Edge> queue;
	static List<Edge> res;

	// edge를 관리할 클래스
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		// 우선순위 큐에 들어가기 위한 조건
		@Override 
		public int compareTo(Edge o) {
			return this.weight < o.weight ? -1 : 1;
		}

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			queue = new PriorityQueue<>(); // weight가 낮은 순 
			check = new boolean[V];
			res = new ArrayList<>();

			// 엣지 정보 저장 
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());

				queue.add(new Edge(from, to, weight));
			}

			kruskal();

			long ans = 0;
			
			// edge 정보에서 weight의 총합 계산
			for (int i = 0; i < res.size(); i++) {
				ans += res.get(i).weight;
			}
			
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}

	private static void kruskal() {
		make(); // 각각 자기 자신을 부모로 할당

		for (int i = 0; i < E; i++) {
			Edge now = queue.poll(); // weight가 낮은 순으로 큐에서 뽑아옴 

			if (find(now.from) == find(now.to)) // loop가 생성된다면 트리가 아니므로 continue
				continue;

			union(now.from, now.to); // 생성안된다면 두 set을 합친 뒤 
			res.add(now); // edge 정보를 저장
		}
	}

	private static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++)
			parents[i] = i;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aParents = parents[a];
		int bParents = parents[b];

		parents[aParents] = bParents;
	}

}
