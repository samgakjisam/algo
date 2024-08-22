import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<ArrayList<int[]>> roads = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int second = Integer.parseInt(st.nextToken());
                if (second == -1) {
                    break;
                }

                int dist = Integer.parseInt(st.nextToken());
                roads.get(first).add(new int[] {second, dist});
            }
        }

        distance = new int[V+1];
        visited = new boolean[V+1];
        visited[0] = true;

        bfs();
        int line = 0;
        for (int i = 1; i <= V; i++) {
            if (line < distance[i]) {
                line = distance[i];
            }
        }

        System.out.println(line);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : roads.get(cur)) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.add(next[0]);
                    distance[next[0]] = distance[cur] + next[1];
                }
            }
        }

        int max = 0;
        int max_node = 0;
        for (int i = 1; i <= V; i++) {
            if (max < distance[i]) {
                max = distance[i];
                max_node = i;
            }
        }

        for (int i = 1; i <= V; i++) {
            distance[i] = 0;
            visited[i] = false;
        }

        q.add(max_node);
        visited[max_node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : roads.get(cur)) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.add(next[0]);
                    distance[next[0]] = distance[cur] + next[1];
                }
            }
        }
    }
}
