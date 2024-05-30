import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] S;
    static int k;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            S = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 6);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void comb(int start, int r) {
        if (r == 0) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    sb.append(S[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            visited[i] = true;
            comb(i+1, r-1);
            visited[i] = false;
        }
    }
}
