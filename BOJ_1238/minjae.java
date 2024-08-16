import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> reverse_list = new ArrayList<>();
    static boolean[] visited;
    static boolean[] reverse_visited;
    static int[] times;
    static int[] reverse_times;
    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= M; i++) {
            list.add(new ArrayList<>());
            reverse_list.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        reverse_visited = new boolean[N+1];
        visited[0] = reverse_visited[0] = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.get(first).add(new int[] {second, time});
            reverse_list.get(second).add(new int[] {first, time});
        }

        times = new int[N+1];
        reverse_times = new int[N+1];
        for (int i = 0; i <= N; i++) {
            times[i] = reverse_times[i] = max;
        }

        dijkstra();
        for (int i = 1; i <= N; i++) {
            times[i] += reverse_times[i];
        }

        int max_time = 0;
        for (int i = 1; i <= N; i++) {
            max_time = Math.max(max_time, times[i]);
        }
        System.out.println(max_time);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        pq.add(new int[] {X, 0});
        times[X] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = true;
            for (int[] next : list.get(cur[0])) {
                if (visited[next[0]]) continue;

                if (times[next[0]] > times[cur[0]] + next[1]) {
                    times[next[0]] = times[cur[0]] + next[1];
                    pq.add(new int[] {next[0], times[next[0]]});
                }
            }
        }

        pq.add(new int[] {X, 0});
        reverse_times[X] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            reverse_visited[cur[0]] = true;
            for (int[] next : reverse_list.get(cur[0])) {
                if (reverse_visited[next[0]]) continue;

                if (reverse_times[next[0]] > reverse_times[cur[0]] + next[1]) {
                    reverse_times[next[0]] = reverse_times[cur[0]] + next[1];
                    pq.add(new int[] {next[0], reverse_times[next[0]]});
                }
            }
        }
    }
}
