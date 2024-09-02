import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] house;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs();
        System.out.println(cnt);
    }

    static void dfs() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, 0, 0, 1});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();

            if (cur[2] == N-1 && cur[3] == N-1) {
                cnt++;
                continue;
            }

            int nsr = cur[2];
            int nsc = cur[3];

            // 가로, 세로, 대각선 구분
            if (cur[0] == cur[2]) {
                for (int i = 0; i < 2; i++) {
                    int ner = nsr + dr[i];
                    int nec = nsc + dc[i];

                    if (ner < N && nec < N) {
                        if (i == 0 && house[ner][nec] == 0) {
                            stack.push(new int[] {nsr, nsc, ner, nec});
                        } else if (i == 1) {
                            if (house[ner][nec] == 0 && house[ner-1][nec] == 0 && house[ner][nec-1] == 0) {
                                stack.push(new int[] {nsr, nsc, ner, nec});
                            }
                        }
                    }
                }
            } else if (cur[1] == cur[3]) {
                for (int i = 1; i < 3; i++) {
                    int ner = nsr + dr[i];
                    int nec = nsc + dc[i];

                    if (ner < N && nec < N) {
                        if (i == 2 && house[ner][nec] == 0) {
                            stack.push(new int[] {nsr, nsc, ner, nec});
                        } else if (i == 1) {
                            if (house[ner][nec] == 0 && house[ner-1][nec] == 0 && house[ner][nec-1] == 0) {
                                stack.push(new int[] {nsr, nsc, ner, nec});
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    int ner = nsr + dr[i];
                    int nec = nsc + dc[i];

                    if (ner < N && nec < N) {
                        if (i == 0 || i == 2) {
                            if (house[ner][nec] == 0) {
                                stack.push(new int[] {nsr, nsc, ner, nec});
                            }
                        } else {
                            if (house[ner][nec] == 0 && house[ner-1][nec] == 0 && house[ner][nec-1] == 0) {
                                stack.push(new int[] {nsr, nsc, ner, nec});
                            }
                        }
                    }
                }
            }
        }
    }
}
