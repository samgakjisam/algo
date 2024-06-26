import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] area;
    static char[][] blind_area;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력들
        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        blind_area = new char[N][N];

        // 정상인이 보는 구역
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                area[i][j] = blind_area[i][j] = temp.charAt(j);
            }
        }

        // 색약이 보는 구역
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 'G') {
                    blind_area[i][j] = 'R';
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] != 'V') {
                    bfs(i, j, area[i][j]);
                    cnt++;
                }
            }
        }

        int blind_cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blind_area[i][j] != 'V') {
                    blind_bfs(i, j, blind_area[i][j]);
                    blind_cnt++;
                }
            }
        }

        System.out.println(cnt + " " + blind_cnt);
    }

    static void bfs(int row, int col, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        area[row][col] = 'V';

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (area[nr][nc] != 'V' && area[nr][nc] == color) {
                        q.add(new int[] {nr, nc});
                        area[nr][nc] = 'V';
                    }
                }
            }
        }
    }

    static void blind_bfs(int row, int col, char color) {
        Queue<int[]> bq = new LinkedList<>();
        bq.add(new int[] {row, col});
        blind_area[row][col] = 'V';

        while (!bq.isEmpty()) {
            int[] current = bq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (blind_area[nr][nc] != 'V' && blind_area[nr][nc] == color) {
                        bq.add(new int[] {nr, nc});
                        blind_area[nr][nc] = 'V';
                    }
                }
            }
        }
    }
}
