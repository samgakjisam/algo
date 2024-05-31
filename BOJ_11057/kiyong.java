package BOJ_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][10];
        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        int ans = 10;
        if (N > 1) {
            for (int i = 1; i < N; i++) {
                ans = 0;
                int tmp = 0;
                for (int j = 9; j >= 0; j--) {
                    tmp += arr[i-1][j];
                    tmp = tmp%10007;
                    arr[i][j] = tmp;
                    ans += tmp;
                }
            }
        }
        System.out.println(ans%10007);
    }
}
