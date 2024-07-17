import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static boolean[] visited;
    static int M;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        visited = new boolean[N];
        temp = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        perm(N, M, 0);
        for (int[] arr : list) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void perm(int n, int r, int idx) {
        if (r == 0) {
            int[] temp2 = new int[M];
            for (int i = 0; i < M; i++) {
                temp2[i] = temp[i];
            }
            boolean insert = true;

            for (int[] arr : list) {
                for (int i = 0; i < M; i++) {
                    if (arr[i] != temp2[i]) {
                        break;
                    }

                    if (i == M-1) {
                        insert = false;
                    }
                }

                if (!insert) {
                    break;
                }
            }

            if (insert) {
                list.add(temp2);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[idx] = numbers[i];
                perm(n, r-1, idx+1);
                visited[i] = false;
            }
        }
    }
}
