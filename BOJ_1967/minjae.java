import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<int[]>> children = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> roads = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            children.add(new ArrayList<>());
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            children.get(p).add(new int[] {c, w});
            roads.get(p).add(new int[] {c, w});
            roads.get(c).add(new int[] {p, w});
        }

        bfs();
        int start_idx = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < distance[i]) {
                max = distance[i];
                start_idx = i;
            }
        }

        for (int i = 0; i <= n; i++) {
            distance[i] = 0;
        }
        second_bfs(start_idx);

        max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < distance[i]) {
                max = distance[i];
            }
        }

        System.out.println(max);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : children.get(cur)) {
                distance[next[0]] = distance[cur] + next[1];
                q.add(next[0]);
            }
        }
    }

    static void second_bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : roads.get(cur)) {
                if (!visited[next[0]]) {
                    q.add(next[0]);
                    visited[next[0]] = true;
                    distance[next[0]] = distance[cur] + next[1];
                }
            }
        }
    }
}
