import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2239 {
	static StringTokenizer st;
	static int[][] map = new int[9][9];
	static List<Zero> empty;

	static class Zero {
		int i, j;

		public Zero(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		empty = new ArrayList<>(); // 공백 리스트

		for (int i = 0; i < 9; i++) {
			String s = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if (map[i][j] == 0)
					empty.add(new Zero(i, j)); // 0이라면 추가
			}
		}

		fillIn(0);
	}

	// 1. 1-9까지 채워넣기
	// 2. 검사했을 때 이상 없다면 다음 공백 채워넣기
	// 3. 공백 개수만큼 다 채워넣었다면 스도쿠 완료

	private static void fillIn(int cnt) {

		if (cnt == empty.size()) { // 스도쿠 완성

			printMap();
			System.exit(0); // 바로 종료

		}

		for (int i = 1; i <= 9; i++) {
			Zero now = empty.get(cnt);

			if (isPossible(now, i)) {// 사각형, 행, 열 확인하기
				map[now.i][now.j] = i;
				fillIn(cnt + 1); // 다음 공백 위치 채워넣기
			}
			map[now.i][now.j] = 0; // 원래대로 돌려 놓기
		}

	}

	private static boolean isPossible(Zero now, int value) {

		int ni = 3 * (now.i / 3); // 현재 위치에서 사각형 시작 행 인덱스
		int nj = 3 * (now.j / 3); // 현재 위치에서 가각형 시작 열 인덱스

		// 사각형 검사 
		for (int i = ni; i < ni + 3; i++) {
			for (int j = nj; j < nj + 3; j++) {
				
				if (map[i][j] == value)
					return false;

			}
		}

		// 열 검사 
		for (int i = 0; i < 9; i++) {

			if (map[now.i][i] == value)
				return false;

		}

		// 행 검사
		for (int i = 0; i < 9; i++) {

			if (map[i][now.j] == value)
				return false;
		}

		return true;
	}

	private static void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
