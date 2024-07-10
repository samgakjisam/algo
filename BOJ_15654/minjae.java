import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static boolean[] visited;
    static int[] idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        visited = new boolean[N];
        idx = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        perm(N, M, 0);
        System.out.println(sb);
    }

    static void perm(int n, int r, int index) {
        if (r == 0) {
            for (int i = 0; i < idx.length; i++) {
                sb.append(numbers[idx[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            idx[index] = i;
            perm(n, r-1, index+1);
            visited[i] = false;
        }
    }
}
