import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] things = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];
        for (int i = 1; i <= N; i++) {
            for (int j = K; j - things[i][0] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-things[i][0]] + things[i][1]);
            }
        }

        System.out.println(dp[K]);
    }
}
