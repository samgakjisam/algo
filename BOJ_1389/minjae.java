import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] relations;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relations = new int[M][2];
        int[] counts = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            relations[i][0] = Integer.parseInt(st.nextToken());
            relations[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            counts[i] = bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 1; i <= N; i++) {
            if (min > counts[i]) {
                min = counts[i];
                num = i;
            }
        }

        System.out.println(num);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N+1];
        int[] count = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int person = q.poll();
            for (int i = 0; i < M; i++) {
                if (relations[i][0] == person && !visited[relations[i][1]]) {
                    q.add(relations[i][1]);
                    visited[relations[i][1]] = true;
                    count[relations[i][1]] = count[relations[i][0]] + 1;
                } else if (relations[i][1] == person && !visited[relations[i][0]]) {
                    q.add(relations[i][0]);
                    visited[relations[i][0]] = true;
                    count[relations[i][0]] = count[relations[i][1]] + 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += count[i];
        }

        return cnt;
    }
}
