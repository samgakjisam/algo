import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paints;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paints = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paints[i][0] = Integer.parseInt(st.nextToken());
            paints[i][1] = Integer.parseInt(st.nextToken());
            paints[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            paints[i][0] += Math.min(paints[i-1][1], paints[i-1][2]);
            paints[i][1] += Math.min(paints[i-1][0], paints[i-1][2]);
            paints[i][2] += Math.min(paints[i-1][0], paints[i-1][1]);
        }

        int min = paints[N-1][0];
        if (Math.min(paints[N-1][1], paints[N-1][2]) < min) {
            min = Math.min(paints[N-1][1], paints[N-1][2]);
        }
        System.out.println(min);
    }
}
