import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] city;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 2) {
                    visited[i][j] = true;
                    comb(i, j, 1);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(min);
    }

    static void comb(int r, int c, int choice) {
        if (choice == M) {
            int[][] distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = 100;
                }
            }

            int[][] visited_arr = new int[M][2];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        visited_arr[idx][0] = i;
                        visited_arr[idx][1] = j;
                        idx++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (city[i][j] == 1) {
                        for (int k = 0; k < M; k++) {
                            distance[i][j] = Math.min(distance[i][j], Math.abs(i - visited_arr[k][0]) + Math.abs(j - visited_arr[k][1]));
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (city[i][j] == 1) {
                        result += distance[i][j];
                    }
                }
            }

            min = Math.min(result, min);
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == r && j <= c) {
                    continue;
                }

                if (city[i][j] == 2) {
                    visited[i][j] = true;
                    comb(i, j, choice+1);
                    visited[i][j] = false;
                }
            }
        }
    }
}
