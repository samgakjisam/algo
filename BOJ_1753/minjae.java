import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[] {v, w});
        }

        visited = new boolean[V+1];
        visited[0] = true;

        result = new int[V+1];
        for (int i = 0; i <= V; i++) {
            result[i] = max;
        }

        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (result[i] == max) {
                sb.append("INF");
            } else {
                sb.append(result[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        result[start] = 0;
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = true;
            for (int[] point : list.get(cur[0])) {
                if (visited[point[0]]) {
                    continue;
                }

                if (result[point[0]] > result[cur[0]] + point[1]) {
                    result[point[0]] = result[cur[0]] + point[1];
                    pq.add(new int[] {point[0], result[point[0]]});
                }
            }
        }
    }
}
