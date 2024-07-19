import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cookies = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = 1000000000;

        while (low < high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (mid <= cookies[i]) {
                    cnt += cookies[i] / mid;
                }
            }

            if (cnt < M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low-1);
    }
}
