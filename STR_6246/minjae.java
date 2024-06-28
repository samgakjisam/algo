import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] check_point;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check_point = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            check_point[i][0] = Integer.parseInt(st.nextToken()) - 1;
            check_point[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(check_point[0][0], check_point[0][1], map, 2);
        System.out.println(cnt);
    }

    static void dfs(int row, int col, int[][] map, int order) {
        int[][] map_copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map_copy[i][j] = map[i][j];
            }
        }
        map_copy[row][col] = order;

        if (row == check_point[m-1][0] && col == check_point[m-1][1]) {
            for (int i = 1; i < m; i++) {
                if (map_copy[check_point[i-1][0]][check_point[i-1][1]] > map_copy[check_point[i][0]][check_point[i][1]]) {
                    return;
                }

                if (i == m-1) {
                    cnt++;
                    return;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (map_copy[nr][nc] == 0) {
                    dfs(nr, nc, map_copy, order+1);
                }
            }
        }
    }
}