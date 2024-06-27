import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[][] vis = new int[N][N];
        int[][] vis2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        int cnt = 0;
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    cnt++;
                    vis[i][j] = cnt;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        int r = tmp[0];
                        int c = tmp[1];
                        char color = arr[r].charAt(c);
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < N && 0 <= nc && nc < N && vis[nr][nc] == 0) {
                                if (arr[nr].charAt(nc) == color) {
                                    vis[nr][nc] = cnt;
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
                if (vis2[i][j] == 0) {
                    q2.offer(new int[]{i, j});
                    cnt2++;
                    vis2[i][j] = cnt;
                    while (!q2.isEmpty()) {
                        int[] tmp = q2.poll();
                        int r = tmp[0];
                        int c = tmp[1];
                        char color = arr[r].charAt(c);
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < N && 0 <= nc && nc < N && vis2[nr][nc] == 0) {
                                if ((color == 'R' || color == 'G') && (arr[nr].charAt(nc) == 'R' || arr[nr].charAt(nc) == 'G')) {
                                    vis2[nr][nc] = cnt;
                                    q2.offer(new int[]{nr, nc});
                                } else if (color == 'B' && arr[nr].charAt(nc) == 'B') {
                                    vis2[nr][nc] = cnt;
                                    q2.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
}
