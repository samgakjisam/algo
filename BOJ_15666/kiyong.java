import java.io.*;
import java.util.*;

public class BOJ_15666 {
    static int N, M;
    static int[] arr;
    static int[] tmp;
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
        sb = new StringBuilder();
        perm(0, 0);
        System.out.println(sb);
    }

    static void perm(int cnt, int start) {
        if (cnt == M) {
            for (int e : tmp) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < N; i++) {
            if (arr[i] != before) {
                tmp[cnt] = arr[i];
                before = arr[i];
                perm(cnt + 1, i);
            }
        }
    }
}
