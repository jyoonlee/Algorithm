import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 섬과 섬 사이 거리 구해서 인접리스트로 만들기
 * 2. 우선순위 큐를 이용해 MST 만들기 
 * 3. 각각의 섬들을 하나의 노드로 만들려면...? 
 * 4. 루프 체크는 어떻게 할까 --> Union-Find 
 * 5. 일단 섬의 개수부터 파악하자,,
 */

public class BJ17472 {
    static StringTokenizer st;
    static int N, M, islandCnt;
    static int[][] map;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static int[] parents;
    static Queue<int[]> queue;
    static PriorityQueue<Path> edge;

    // 각각의 경로를 표시할 클래스
    static class Path implements Comparable<Path> {
        int from;
        int to;
        int weight;

        public Path(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 우선순위 큐에 넣기 위해
        @Override
        public int compareTo(Path o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Path [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 맵 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 섬 라벨링을 위해 -1로 마킹
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }

        // 섬 개수 세기, 섬 번호 부여하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    islandCnt++;
                    map[i][j] = islandCnt;
                    labeling(i, j);
                }
            }
        }

        // parents 배열 만들어서 초기화 시키기
        parents = new int[islandCnt + 1];
        for (int i = 0; i < islandCnt + 1; i++) {
            parents[i] = i;
        }

        // 엣지 정보 구해서 넣어주자
        edge = new PriorityQueue<>();

        // 각 섬에 속해있는 점들에서 엣지를 찾아서 우선순위 큐에 저장
        for (int k = 1; k <= islandCnt; k++) {
            queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == k)
                        checkEdge(i, j, k);
                }
            }
        }

        int cnt = 0;
        int res = 0;

        // 우선순위 큐에서 최소 weight 별로 불러와 크루스칼로 MST 만들기
        while (!edge.isEmpty()) {

            Path now = edge.poll();
            int from = now.from;
            int to = now.to;
            int weight = now.weight;

            if (find(from) == find(to)) // 만약 루프가 만들어지면 다음 엣지 사용
                continue;

            union(from, to); // 아니라면 두 섬 연결
            res += weight; // 길이 저장
            cnt++; // 연결된 엣지 수 저장

            if (cnt == islandCnt - 1) // MST가 만들어졌다면
                break;
        }
        
        System.out.println(cnt == islandCnt - 1?res:-1);
    }

    private static void labeling(int i, int j) {

        // 4방 탐색
        for (int idx = 0; idx < 4; idx++) {

            int ni = i + dy[idx];
            int nj = j + dx[idx];

            if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == -1) { // 내 인접점이 육지로 되어있다면?
                map[ni][nj] = islandCnt; // 섬 번호 부여
                labeling(ni, nj); // dfs
            }
        }
    }

    private static void checkEdge(int i, int j, int me) {

        // 4방 탐색
        for (int idx = 0; idx < 4; idx++) {

            int ni = i;
            int nj = j;
            int cnt = 0;
            int to = 0;
            boolean flag = true;

            while (true) {

                ni += dy[idx];
                nj += dx[idx];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == me) { // 나 자신을 만나거나 범위 밖으로 벗어난다면
                    flag = false; // 의미 없는 값
                    break;
                }

                if (map[ni][nj] != 0) { // 만약 내가 아닌 다른 섬을 만났다면?
                    to = map[ni][nj]; // 그 섬의 번호를 저장
                    break;
                }
                cnt++; // 거리 재기
            }

            if (flag && cnt > 1) // 거리가 1보다 크고, 다른 섬을 만났다면
                edge.add(new Path(me, to, cnt)); // 엣지 정보 저장
        }
    }

    private static int find(int a) {
        if (parents[a] == a)
            return a;

        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int aParents = find(a);
        int bParents = find(b);

        parents[bParents] = aParents;
    }
}