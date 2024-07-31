import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < N; j++) {
                table[i][j] = table[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s_row = Integer.parseInt(st.nextToken()) - 1;
            int s_col = Integer.parseInt(st.nextToken()) - 1;
            int e_row = Integer.parseInt(st.nextToken()) - 1;
            int e_col = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int j = s_row; j <= e_row; j++) {
                if (s_col == 0) {
                    sum += table[j][e_col];
                } else {
                    sum += table[j][e_col] - table[j][s_col-1];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
