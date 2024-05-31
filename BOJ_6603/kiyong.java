package BOJ_6603;

import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String nums = br.readLine();
            if (nums.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(nums);
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i=0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N];
            com(arr, visited, 0, N, 6, bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static void com(int[] arr, boolean[] visited, int start, int n, int r, BufferedWriter bw) throws IOException {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    bw.write(arr[i] + " ");
                }
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            com(arr, visited, i+1, n, r-1, bw);
            visited[i] = false;
        }
    }
}
