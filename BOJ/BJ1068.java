import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 리프노드 찾기 문제, 중간 트리 끊기 처리(DFS) 
// 1068번 

public class BJ1068 {
	static StringTokenizer st;
	static int N, M, res, root;
	static List<Integer>[] adjList;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		adjList = new ArrayList[N];
		check = new boolean[N];
		root = -1;
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			if (now != -1) {
				adjList[i].add(now);
				adjList[now].add(i);
			}
			else
				root = i;
		}

		M = Integer.parseInt(in.readLine());
		
		if (M != root)
			dfs(root);
		System.out.println(res);
	}

	private static void dfs(int i) {

		check[i] = true;
		adjList[i].remove(Integer.valueOf(M));

		for (int now : adjList[i]) {
			if (!check[now])
				dfs(now);
		}

		if (adjList[i].size() == 1 && i != root) {
			res++;
		}
		else if (adjList[i].size() == 0 && i == root)
			res++;
	}
}

/*7
3 6 6 -1 0 6 3
4*/