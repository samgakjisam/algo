import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        Deque<int[]> talls = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
            while (!talls.isEmpty()) {
                if (towers[i] < talls.peekLast()[1]) {
                    sb.append(" ");
                    sb.append(talls.peekLast()[0]);
                    break;
                }
                talls.pollLast();
                if (talls.isEmpty()) {
                    sb.append(" ");
                    sb.append(0);
                }
            }
            talls.offerLast(new int[]{i+1, towers[i]});
        }
        System.out.println(sb);
    }
}
