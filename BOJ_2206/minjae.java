import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] distance;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        distance = new int[N][M];
        visited = new boolean[2][N][M];

        bfs();
        if (distance[N-1][M-1] == 0) {
            distance[N-1][M-1] = -1;
        }
        System.out.println(distance[N-1][M-1]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0});
        map[0][0] = 2;
        distance[0][0] = 1;
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1) {
                        if (cur[2] == 0 && !visited[1][nr][nc]) {
                            q.add(new int[] {nr, nc, 1});
                            distance[nr][nc] = distance[cur[0]][cur[1]] + 1;
                            visited[cur[2]][nr][nc] = true;
                        }
                    } else {
                        if (!visited[cur[2]][nr][nc]) {
                            visited[cur[2]][nr][nc] = true;
                            distance[nr][nc] = distance[cur[0]][cur[1]] + 1;
                            q.add(new int[] {nr, nc, cur[2]});
                        }
                    }

                    if (nr == N-1 && nc == M-1) {
                        q.clear();
                        break;
                    }
                }
            }
        }
    }
}
