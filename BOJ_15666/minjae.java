import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] input_check = new boolean[10000];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int input_num = Integer.parseInt(st.nextToken());
            if (input_check[input_num-1]) {
                continue;
            }

            input_check[input_num-1] = true;
            cnt++;
        }

        numbers = new int[cnt];
        visited = new int[cnt];
        int idx = 0;
        for (int i = 0; i < 10000; i++) {
            if (input_check[i]) {
                numbers[idx] = i+1;
                idx++;
            }
        }

        comb(cnt, M, 0);
        System.out.println(sb);
    }

    static void comb(int n, int r, int start) {
        if (r == 0) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = visited[i];
            }

            for (int i = 0; i < n; i++) {
                while (temp[i] > 0) {
                    sb.append(numbers[i]).append(" ");
                    temp[i]--;
                }
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i]++;
            comb(n, r-1, i);
            visited[i]--;
        }
    }
}
