import java.io.*;
import java.util.*;

public class Main {
    static int N, M, W;
    static ArrayList<ArrayList<int[]>> roads;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            roads = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                roads.add(new ArrayList<>());
            }
            dist = new long[N+1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                roads.get(start).add(new int[] {end, time});
                roads.get(end).add(new int[] {start, time});
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                roads.get(start).add(new int[] {end, -time});
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if (!isMinusCycle) {
                sb.append("NO\n");
            }
        } // t for

        System.out.println(sb);
    }

    // 벨만포드
    static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        // N-1번 동안 최단거리 초기화 작업 진행
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (int[] next : roads.get(j)) {
                    if (dist[j] != INF && dist[next[0]] > dist[j] + next[1]) {
                        dist[next[0]] = dist[j] + next[1];
                        update = true;
                    }
                }
            }

            if (!update) break; // 최단거리 초기화가 이뤄지지 않는다면 중지
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (int[] next : roads.get(i)) {
                    if (dist[i] != INF && dist[next[0]] > dist[i] + next[1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
