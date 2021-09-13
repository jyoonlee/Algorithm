import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름 문제

public class BJ1167 {
	static StringTokenizer st;
	static List<int[]>[] adjList;
	static boolean[] visited;
	static int res, max, lastIdx;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		adjList = new ArrayList[N];

		// 인접 리스트를 담을 곳 초기화
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		// 인접 리스트 생성
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int node = Integer.parseInt(st.nextToken()) - 1; // 현재 번호
			while (st.hasMoreElements()) {
				int nodeNum = Integer.parseInt(st.nextToken()) - 1; // 연결된 노드
				if (nodeNum == -2) // 종료 구문
					break;

				int weight = Integer.parseInt(st.nextToken()); // 가중치
				adjList[node].add(new int[] { nodeNum, weight });
			}
		}

		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 0); // 가장 가중치가 높도록 만드는 리프 노드 찾기

		max = 0;
		visited = new boolean[N]; // 그 리프 노드에서 다시 가장 가중치 높도록 하는 곳 찾기
		visited[lastIdx] = true;
		dfs(lastIdx, 0);

		System.out.println(max);
	}

	private static void dfs(int i, int value) {

		if (max < value) { // 가중치로 맥스 값 or 리프 노드 인덱스 번호 찾는다.
			max = value;
			lastIdx = i;
		}

		for (int idx = 0; idx < adjList[i].size(); idx++) {
			int[] now = adjList[i].get(idx);

			if (!visited[now[0]]) {
				visited[now[0]] = true;
				dfs(now[0], value + now[1]);
				visited[now[0]] = false;
			}
		}
	}
}
