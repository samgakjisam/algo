package BOJ_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kiyong {
    public static int w;
    public static int b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        w = 0;
        b = 0;
        cut(N, 0, 0, arr);
        System.out.println(w + "\n" + b);
    }

    public static void cut(int N, int startX, int startY, int[][] arr) {
        int blueCnt = 0;
        int whiteCnt = 0;
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (arr[i][j] == 0) {
                    whiteCnt++;
                } else {
                    blueCnt++;
                }
            }
        }
        if (blueCnt == N * N) {
            b++;
            return;
        }
        if (whiteCnt == N * N) {
            w++;
            return;
        }
        N /= 2;
        cut(N, startX, startY, arr);
        cut(N, startX + N, startY, arr);
        cut(N, startX, startY + N, arr);
        cut(N, startX + N, startY + N, arr);
    }
}
