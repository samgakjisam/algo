import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] ladder_info;
    static int[][] snake_info;
    static int[] distance = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder_info = new int[N][2];
        snake_info = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder_info[i][0] = Integer.parseInt(st.nextToken());
            ladder_info[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake_info[i][0] = Integer.parseInt(st.nextToken());
            snake_info[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= 100; i++) {
            distance[i] = 101;
        }

        bfs();
        System.out.println(distance[100]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean teleport = false;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < N; i++) {
                if (ladder_info[i][0] == cur) {
                    if (distance[ladder_info[i][1]] > distance[cur]) {
                        distance[ladder_info[i][1]] = distance[cur];
                        q.add(ladder_info[i][1]);
                    }
                    teleport = true;
                }
            }

            for (int i = 0; i < M; i++) {
                if (snake_info[i][0] == cur) {
                    if (distance[snake_info[i][1]] > distance[cur]) {
                        distance[snake_info[i][1]] = distance[cur];
                        q.add(snake_info[i][1]);
                    }
                    teleport = true;
                }
            }

            if (!teleport) {
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    if (next <= 100) {
                        if (distance[next] > distance[cur] + 1) {
                            distance[next] = distance[cur] + 1;
                            q.add(next);
                        }
                    }
                }
            }
            teleport = false;
        }
    }
}
