import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int now = 1;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { arr[i][j] = -1; }
            }
        }
        int n = 0;
        boolean[][] vis = new boolean[N][N];
        boolean is_start = true;
        int start_r = 0;
        int start_c = 0;
        for (int i = 0; i < M; i++) {
            n++;
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r-1][c-1] = n;
            if (is_start) {
                start_r = r-1;
                start_c = c-1;
                is_start = false;
            }
        }
        vis[start_r][start_c] = true;
        dfs(start_r, start_c, N, M, vis, arr);
        System.out.println(cnt);
    }

    static void dfs(int r, int c, int N, int M, boolean[][] vis, int[][] arr) {
        if (arr[r][c] == M) {
            cnt++;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nc && nc < N && 0 <= nr && nr < N && !vis[nr][nc] && arr[nr][nc] >= 0
               && arr[nr][nc] <= now+1) {
                if (arr[nr][nc] == now+1) {
                    now++;
                    vis[nr][nc] = true;
                    dfs(nr, nc, N, M, vis, arr);
                    vis[nr][nc] = false;
                    now--;
                } else {
                    vis[nr][nc] = true;
                    dfs(nr, nc, N, M, vis, arr);
                    vis[nr][nc] = false;
                }
            }
        }
    }
}
