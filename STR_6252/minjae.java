import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;
    static long[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        a = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);

        long low = a[0];
        long high = 1000000000L;
        
        while (low < high) {
            long mid = (low + high) / 2;

            long cost = 0;
            for (int i = 0; i < N; i++) {
                if (mid <= a[i]) {
                    break;
                }

                cost += (mid - a[i]) * (mid - a[i]);
            }

            if (cost > B) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low-1);
    }
}
