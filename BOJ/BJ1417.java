import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐의 초기 상태는 오름차순이다

public class BJ1417 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> input = new PriorityQueue<>(Collections.reverseOrder());

		int me = Integer.parseInt(in.readLine());
		int res = 0;

		for (int i = 0; i < N - 1; i++)
			input.add(Integer.parseInt(in.readLine()));
		
		// 출마 인원이 한명이 아니라면 비교 
		if (N > 1) {
			while (true) {

				int now = input.poll();

				if (me > now)
					break;

				res++;
				me++;
				input.offer(now - 1);
			}
		}

		System.out.println(res);

	}
}
