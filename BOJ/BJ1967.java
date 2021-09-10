import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1967 {
	static StringTokenizer st;
	static int N, res;
	static List<int[]>[] adjList;
	static boolean[] check;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());

		adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 인접 리스트 저장 
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new int[] { to, weight });
			adjList[to].add(new int[] { from, weight });
		}

		for (int i = 0; i < N - 1; i++) {
			if (adjList[i].size() == 1) { // 리프 노드일 경우 
				check = new boolean[N];
				dfs(i, 0); // 탐색 시작 
			}
		}

		System.out.println(res);
	}

	private static void dfs(int now, int value) {
		List<int[]> currentNode = adjList[now];
		boolean flag = true;

		for (int i = 0; i < currentNode.size(); i++) { // 노드 끝까지 탐색 
			if (!check[currentNode.get(i)[0]]) {
				check[currentNode.get(i)[0]] = true;
				dfs(currentNode.get(i)[0], value + currentNode.get(i)[1]);
				flag = false;
			}
		}

		if (flag)
			res = Integer.max(res, value); // 탐색이 끝나면 최장길이 저장
	}
}
