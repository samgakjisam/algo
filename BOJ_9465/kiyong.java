import java.io.*;
import java.util.*;

public class kiyong {
    static int n;
    static int max_v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    if (i == 0) {
                        dp[i][j] = arr[i][j];
                    } else if (i == 1) {
                        dp[i][j] = dp[i - 1][1 - j] + arr[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][1 - j], dp[i - 2][1 - j]) + arr[i][j];
                    }
                }
            }
            max_v = Math.max(dp[n - 1][0], dp[n - 1][1]);
            System.out.println(max_v);
        }
    }
}
