import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];
        int row = -1;
        int col = -1;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = temp.charAt(j);

                if (campus[i][j] == 'I') {
                    row = i;
                    col = j;
                } else if (campus[i][j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }

        bfs(row, col);
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (campus[temp[0]][temp[1]] == 'P') {
                cnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc]) {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
