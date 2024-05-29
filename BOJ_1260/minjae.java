import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int V;
    static boolean[][] M_info;
    static boolean[] dfs_visited;
    static boolean[] bfs_visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        M_info = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int M_one = Integer.parseInt(st.nextToken());
            int M_two = Integer.parseInt(st.nextToken());
            M_info[M_one][M_two] = true;
            M_info[M_two][M_one] = true;
        }

        dfs_visited = new boolean[N+1];
        bfs_visited = new boolean[N+1];
        dfs_visited[0] = bfs_visited[0] = true;

        // Arrays.sort(M_info, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        dfs(V);
        sb.append("\n");

        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int start) {
        sb.append(start).append(" ");
        dfs_visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (M_info[start][i] && !dfs_visited[i]) {
                dfs_visited[i] = true;
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        bfs_visited[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {
                if (M_info[cur][i] && !bfs_visited[i]) {
                    q.add(i);
                    bfs_visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
