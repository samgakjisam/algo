import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] distance_map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance_map = new int[n][m];
        int s_row = -1;
        int s_col = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    s_row = i;
                    s_col = j;
                }
            }
        }

        bfs(s_row, s_col);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(distance_map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int s_row, int s_col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s_row, s_col});
        map[s_row][s_col] = 0;

        while (!q.isEmpty()) {
            int[] current_position = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current_position[0] + dr[i];
                int nc = current_position[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        distance_map[nr][nc] = distance_map[current_position[0]][current_position[1]] + 1;
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }
}
