import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// union-find를 이용해서 부모 비교하기

public class BJ1976 {
	static StringTokenizer st;
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		make();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) // 이어져있다면 합쳐주기
					union(i, j);
			}
		}

		// 부모 갱신하기
		for (int i = 0; i < N; i++) {
			find(i);
		}

		// 하나 이하라면 무조건 갈 수 있음
		if (M <= 1) {
			System.out.println("YES");
		} else {
			// 가야하는 곳이 두개 이상이라면 부모 비교하기
			st = new StringTokenizer(in.readLine());
			int value = Integer.parseInt(st.nextToken()) - 1;
			int root = parents[value];
			boolean flag = true;

			for (int i = 0; i < M - 1; i++) {
				int now = Integer.parseInt(st.nextToken()) - 1;
				if (root != parents[now]) {
					flag = false;
					break;
				}
			}

			// 결과
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int i) {
		if (parents[i] == i)
			return i;

		return parents[i] = find(parents[i]);
	}

	public static void union(int i, int j) {

		int aParents = find(i);
		int bParents = find(j);

		parents[bParents] = aParents;
	}
}