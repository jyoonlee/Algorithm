package com.ssafy.algorithm.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5644 {
	static int M, A;
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };
	static StringTokenizer st;
	static int[][] now;
	static String[] pathA;
	static String[] pathB;
	static List<BC> BCs;
	static int res;

	// 배터리 충전소 클래스
	public static class BC implements Comparable<BC> {
		int id;
		int y;
		int x;
		int coverage;
		int amount;

		BC(int id, int x, int y, int coverage, int amount) {
			this.id = id;
			this.y = y - 1;
			this.x = x - 1;
			this.coverage = coverage;
			this.amount = amount;
		}

		@Override
		public int compareTo(BC o) {
			return this.amount - o.amount; // 오름차순으로 객체를 정렬
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			BCs = new ArrayList<>(A); // 배터리를 담을 리스트
			now = new int[][] { { 0, 0 }, { 9, 9 } }; // 초기 위치

			pathA = in.readLine().split(" "); // A의 경로
			pathB = in.readLine().split(" "); // B의 경로

			// 배터리 충전소 저장
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int coverage = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				BCs.add(new BC(i, x, y, coverage, amount)); // 충전소 객체 생성
			}

			// 탐색 시작
			move();
			System.out.printf("#%d %d%n", test_case, res);
			res = 0;
		}
	}

	private static void move() {

		charge();

		// 명령 수 만큼 이동
		for (int i = 0; i < M; i++) {
			int dir1 = Integer.parseInt(pathA[i]); // 명령에 따른 델타 방향
			int dir2 = Integer.parseInt(pathB[i]); // 명령에 따른 델타 방향

			// 사람의 위치를 델타 이동 시킨 뒤 충전소 탐색
			now[0][0] += dy[dir1];
			now[0][1] += dx[dir1];
			now[1][0] += dy[dir2];
			now[1][1] += dx[dir2];

			charge(); // 주변의 최적 충전소는?
		}
	}

	private static void charge() {

		List<BC> canCharge1 = new ArrayList<>(); // 사람1이 충전 가능한 곳
		List<BC> canCharge2 = new ArrayList<>(); // 사람2이 충전 가능한 곳

		for (int i = 0; i < BCs.size(); i++) { // 사람1의 충전소 탐색
			if (Math.abs(now[0][0] - BCs.get(i).y) + Math.abs(now[0][1] - BCs.get(i).x) <= BCs.get(i).coverage) { // 범위
				canCharge1.add(BCs.get(i)); // 사용 가능 충전소 리스트에 충전량 저장
			}
		}

		for (int i = 0; i < BCs.size(); i++) { // 사람2 계산
			if (Math.abs(now[1][0] - BCs.get(i).y) + Math.abs(now[1][1] - BCs.get(i).x) <= BCs.get(i).coverage) {
				canCharge2.add(BCs.get(i));
			}
		}

		Collections.sort(canCharge1); // 소팅
		Collections.sort(canCharge2);

		if (canCharge1.size() + canCharge2.size() == 0) // 충전소가 없는 경우 리턴
			return;

		else if (canCharge1.size() == 0) // 사람2만 가능할 경우
			res += Collections.max(canCharge2).amount;

		else if (canCharge2.size() == 0) // 사람1만 가능할 경우
			res += Collections.max(canCharge1).amount;

		else if (Collections.max(canCharge1).amount != Collections.max(canCharge2).amount) // 둘이 가능한 충전소의 최대 값을 저장
			res += Collections.max(canCharge1).amount + Collections.max(canCharge2).amount;

		else { // 공통 되는 경우
			if (Collections.max(canCharge1).id != Collections.max(canCharge2).id) { // 충전량이 같더라도 id 값이 다르다면 같은 충전소가 아니다
				res += Collections.max(canCharge1).amount + Collections.max(canCharge2).amount;
				return;
			}

			int max = Collections.max(canCharge1).id; // 현재 공통으로 대상이 될 충전소 id
			BC temp1 = null;
			BC temp2 = null;

			// 차선책이 있는 지 확인하기
			for (int i = canCharge1.size() - 1; i >= 0; i--) {
				if (max != canCharge1.get(i).id) {
					temp1 = canCharge1.get(i);
					break;
				}
			}

			for (int i = canCharge2.size() - 1; i >= 0; i--) {
				if (max != canCharge2.get(i).id) {
					temp2 = canCharge2.get(i);
					break;
				}
			}

			// 차선책이 있다면 해당 방식으로, 없다면 같은 충전소 쓰게 한다.
			if (temp1 != null && temp2 != null) {
				int temp = Integer.max(temp1.amount, temp2.amount);
				res += BCs.get(max).amount + temp;
			} else if (temp1 == null && temp2 == null) {
				res += BCs.get(max).amount;
			} else if (temp1 != null) {
				res += BCs.get(max).amount + temp1.amount;
			} else if (temp2 != null) {
				res += BCs.get(max).amount + temp2.amount;
			}
		}
	}
}
