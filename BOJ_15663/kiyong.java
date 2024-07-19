import java.io.*;
import java.util.*;

public class BOJ_15663 {
    static int N, M;
    static int[] arr;
    static int[] tmp;
    static boolean[] vis;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        tmp = new int[M];
        vis = new boolean[N];
        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int e : tmp) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i] && arr[i] != before) {
                vis[i] = true;
                tmp[cnt] = arr[i];
                before = arr[i];
                perm(cnt + 1);
                vis[i] = false;
            }
        }
    }
}
