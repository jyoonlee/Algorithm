import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 특정 조건으로 깊이 탐색 

public class BJ13023 {
	static StringTokenizer st;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int res, cnt, N;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];

		// 인접 리스트를 담을 곳 초기화
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		// 인접 리스트 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int node = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			// 친구 관계이므로 쌍방으로 등록
			adjList[node].add(child);
			adjList[child].add(node);
		}

		// 각각의 친구 위치로부터 깊이 탐색하여 친구관계가 있는 지 확인해보자
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true; // 방문 체크
			dfs(i, 0);

			if (res == 1) // 친구 관계 찾았다면 탈출 후 출력
				break;
		}

		System.out.println(res);
	}

	private static void dfs(int now, int cnt) {

		if (cnt == 4) { // 깊이가 4인 트리 찾기
			res = 1;
			return;
		}

		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);

			// 깊이 탐색, 방문 체크
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
}
