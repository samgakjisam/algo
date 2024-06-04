import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan_list = new int[K];
        for (int i = 0; i < K; i++) {
            lan_list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan_list);

        long left = 1;
        long right = lan_list[K-1];
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += lan_list[i] / mid;
            }

            if (cnt < N) {
                right = mid - 1;
                if (right < left) {
                    left--;
                }
            } else if (cnt >= N) {
                left = mid + 1;
            }
        }
        System.out.println(mid);
    }
}
