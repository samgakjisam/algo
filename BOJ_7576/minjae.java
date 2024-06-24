import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] box;
    static int[][] day;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        day = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        int max = -1;
        boolean isFail = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    max = -1;
                    isFail = true;
                    break;
                }

                max = Math.max(max, day[i][j]);
            }

            if (isFail) {
                break;
            }
        }

        System.out.println(max);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (box[nr][nc] == 0) {
                        q.add(new int[] {nr, nc});
                        day[nr][nc] = day[current[0]][current[1]] + 1;
                        box[nr][nc] = 1;
                    }
                }
            }
        }
    }
}
