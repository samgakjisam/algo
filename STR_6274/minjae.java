import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int T;
    static int[][][] roads;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        roads = new int[N][N][4];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    roads[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[3] == T) break;

            switch (roads[cur[0]][cur[1]][cur[3] % 4] % 4) {
                case 0: // 위쪽에서 진입하는 경우
                    if (cur[2] == 2) {
                        if (cur[0] + 1 < N) {
                            q.add(new int[] {cur[0]+1, cur[1], 2, cur[3]+1});
                            visited[cur[0]+1][cur[1]] = true;
                        }

                        if (roads[cur[0]][cur[1]][cur[3] % 4] == 8) {
                            if (cur[1] + 1 < N) {
                                q.add(new int[] {cur[0], cur[1]+1, 1, cur[3]+1});
                                visited[cur[0]][cur[1]+1] = true;
                            }
                        } else if (roads[cur[0]][cur[1]][cur[3] % 4] == 12) {
                            if (cur[1] - 1 >= 0) {
                                q.add(new int[] {cur[0], cur[1]-1, 3, cur[3]+1});
                                visited[cur[0]][cur[1]-1] = true;
                            }
                        } else {
                            if (cur[1] + 1 < N) {
                                q.add(new int[] {cur[0], cur[1]+1, 1, cur[3]+1});
                                visited[cur[0]][cur[1]+1] = true;
                            }
                            if (cur[1] - 1 >= 0) {
                                q.add(new int[] {cur[0], cur[1]-1, 3, cur[3]+1});
                                visited[cur[0]][cur[1]-1] = true;
                            }
                        }
                    }
                    break;
                case 1: // 왼쪽에서 진입하는 경우
                    if (cur[2] == 1) {
                        if (cur[1] + 1 < N) {
                            q.add(new int[] {cur[0], cur[1]+1, 1, cur[3]+1});
                            visited[cur[0]][cur[1]+1] = true;
                        }

                        if (roads[cur[0]][cur[1]][cur[3] % 4] == 5) {
                            if (cur[0] - 1 >= 0) {
                                q.add(new int[] {cur[0]-1, cur[1], 0, cur[3]+1});
                                visited[cur[0]-1][cur[1]] = true;
                            }
                        } else if (roads[cur[0]][cur[1]][cur[3] % 4] == 9) {
                            if (cur[0] + 1 < N) {
                                q.add(new int[] {cur[0]+1, cur[1], 2, cur[3]+1});
                                visited[cur[0]+1][cur[1]] = true;
                            }
                        } else {
                            if (cur[0] - 1 >= 0) {
                                q.add(new int[] {cur[0]-1, cur[1], 0, cur[3]+1});
                                visited[cur[0]-1][cur[1]] = true;
                            }
                            if (cur[0] + 1 < N) {
                                q.add(new int[] {cur[0]+1, cur[1], 2, cur[3]+1});
                                visited[cur[0]+1][cur[1]] = true;
                            }
                        }
                    }
                    break;
                case 2: // 아래쪽에서 진입하는 경우
                    if (cur[2] == 0) {
                        if (cur[0] - 1 >= 0) {
                            q.add(new int[] {cur[0]-1, cur[1], 0, cur[3]+1});
                            visited[cur[0]-1][cur[1]] = true;
                        }

                        if (roads[cur[0]][cur[1]][cur[3] % 4] == 6) {
                            if (cur[1] - 1 >= 0) {
                                q.add(new int[] {cur[0], cur[1]-1, 3, cur[3]+1});
                                visited[cur[0]][cur[1]-1] = true;
                            }
                        } else if (roads[cur[0]][cur[1]][cur[3] % 4] == 10) {
                            if (cur[1] + 1 < N) {
                                q.add(new int[] {cur[0], cur[1]+1, 1, cur[3]+1});
                                visited[cur[0]][cur[1]+1] = true;
                            }
                        } else {
                            if (cur[1] - 1 >= 0) {
                                q.add(new int[] {cur[0], cur[1]-1, 3, cur[3]+1});
                                visited[cur[0]][cur[1]-1] = true;
                            }
                            if (cur[1] + 1 < N) {
                                q.add(new int[] {cur[0], cur[1]+1, 1, cur[3]+1});
                                visited[cur[0]][cur[1]+1] = true;
                            }
                        }
                    }
                    break;
                case 3: // 오른쪽에서 진입하는 경우
                    if (cur[2] == 3) {
                        if (cur[1] - 1 >= 0) {
                            q.add(new int[] {cur[0], cur[1]-1, 3, cur[3]+1});
                            visited[cur[0]][cur[1]-1] = true;
                        }

                        if (roads[cur[0]][cur[1]][cur[3] % 4] == 7) {
                            if (cur[0] + 1 < N) {
                                q.add(new int[] {cur[0]+1, cur[1], 2, cur[3]+1});
                                visited[cur[0]+1][cur[1]] = true;
                            }
                        } else if (roads[cur[0]][cur[1]][cur[3] % 4] == 11) {
                            if (cur[0] - 1 >= 0) {
                                q.add(new int[] {cur[0]-1, cur[1], 0, cur[3]+1});
                                visited[cur[0]-1][cur[1]] = true;
                            }
                        } else {
                            if (cur[0] + 1 < N) {
                                q.add(new int[] {cur[0]+1, cur[1], 2, cur[3]+1});
                                visited[cur[0]+1][cur[1]] = true;
                            }
                            if (cur[0] - 1 >= 0) {
                                q.add(new int[] {cur[0]-1, cur[1], 0, cur[3]+1});
                                visited[cur[0]-1][cur[1]] = true;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
