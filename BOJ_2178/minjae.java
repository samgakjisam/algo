import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] maze;
    static int[][] distance;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(distance[N-1][M-1]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        maze[0][0] = 0;
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (maze[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        maze[nr][nc] = 0;
                        distance[nr][nc] = distance[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }
}
