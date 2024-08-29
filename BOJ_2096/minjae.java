import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] max_dp = new int[N][3];
        int[][] min_dp = new int[N][3];

        max_dp[0][0] = min_dp[0][0] = points[0][0];
        max_dp[0][1] = min_dp[0][1] = points[0][1];
        max_dp[0][2] = min_dp[0][2] = points[0][2];

        for (int i = 1; i < N; i++) {
            max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1]) + points[i][0];
            max_dp[i][2] = Math.max(max_dp[i-1][2], max_dp[i-1][1]) + points[i][2];
            max_dp[i][1] = Math.max(Math.max(max_dp[i-1][0], max_dp[i-1][1]), max_dp[i-1][2]) + points[i][1];

            min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1]) + points[i][0];
            min_dp[i][2] = Math.min(min_dp[i-1][2], min_dp[i-1][1]) + points[i][2];
            min_dp[i][1] = Math.min(Math.min(min_dp[i-1][0], min_dp[i-1][1]), min_dp[i-1][2]) + points[i][1];
        }

        int max = Math.max(max_dp[N-1][0], Math.max(max_dp[N-1][1], max_dp[N-1][2]));
        int min = Math.min(Math.min(min_dp[N-1][0], min_dp[N-1][1]), min_dp[N-1][2]);
        System.out.println(max + " " + min);
    }
}
