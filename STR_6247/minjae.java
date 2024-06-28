import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] oil_meter = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil_meter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(oil_meter);

        for (int i = 0; i < q; i++) {
            int center = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n - 1;
            int mid = 0;
            boolean search = false;

            while (left <= right) {
                mid = (left + right) / 2;
                if (oil_meter[mid] > center) {
                    right = mid-1;
                } else if (oil_meter[mid] < center) {
                    left = mid + 1;
                } else {
                    search = true;
                    break;
                }
            }

            if (search) {
                int left_cnt = mid;
                int right_cnt = n - mid - 1;
                sb.append(left_cnt * right_cnt);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}