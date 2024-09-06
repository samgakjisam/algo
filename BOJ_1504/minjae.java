import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int E;
    static ArrayList<ArrayList<int[]>> roads = new ArrayList<>();
    static int v1, v2;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N+1];

        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            roads.get(first).add(new int[] {second, cost});
            roads.get(second).add(new int[] {first, cost});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long first_cost = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long second_cost = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        long min = Math.min(first_cost, second_cost);
        if (min >= INF) {
            min = -1;
        }

        System.out.println(min);
    }

    static long dijkstra(int start, int end) {
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        dist[start] = 0;
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] next: roads.get(cur[0])) {
                if (dist[next[0]] > cur[1] + next[1]) {
                    dist[next[0]] = cur[1] + next[1];
                    pq.add(new int[] {next[0], dist[next[0]]});
                }
            }
        }

        return dist[end];
    }
}
