import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 이분 그래프 (두가지 색으로 칠하기)

public class BJ1707 {
	static StringTokenizer st;
	static List<Integer>[] adjList;
	static int V, E, color;
	static String res;
	static boolean flag;
	static int[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(in.readLine());

		for (int i = 0; i < k; i++) {

			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// 초기 세팅
			check = new int[V];
			color = 1;
			flag = false;
			res = "NO";

			adjList = new ArrayList[V];

			// 인접리스트 초기화
			for (int j = 0; j < V; j++)
				adjList[j] = new ArrayList<>();

			// 인접리스트 만들기
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;

				adjList[from].add(to);
				adjList[to].add(from);
			}

			// 첫번째 노드 입력
			check[0] = color;
			color *= -1;

			// 돌아가면서 색칠하기 
			for (int j = 0; j < V; j++) {
				dfs(j);
				if (flag) // 같은 색이 연속으로 나오면 이분그래프가 아니다
					break;
				else
					res = "YES";
			}

			System.out.println(res);
		}
	}

	// 자식 노드 방문하면서 색칠하고 다니기 
	private static void dfs(int j) {

       // System.out.println(Arrays.toString(check));
		List<Integer> now = adjList[j];

		for (int i = 0; i < now.size(); i++) {

			int value = now.get(i);
			if (check[value] == 0) {
				check[value] = color;
				color *= -1;
				dfs(value);
				color *= -1;
			} else {
				if (check[value] == check[j]) {
					flag = true;
					res = "NO";
					return;
				}
			}

		}

	}
}
