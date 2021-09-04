import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ11724 {
	static StringTokenizer st;
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b); // 연결시켜주기
		}

		
		for (int i = 0; i < N; i++) {
			find(i); // 부모 찾기 재정렬
		}
		
		Set<Integer> check = new HashSet<>();
		for (int i = 0; i < N; i++) {
			check.add(parents[i]); // set에 넣어 고유 개수 세기
		}
		
		System.out.println(check.size()); // 결과 값 출력
	}

	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		if(find(b) == find(a))
			return;
		
		parents[find(b)] = find(a);
	}

}
