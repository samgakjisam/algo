import java.io.*;
import java.util.*;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(arr[0], 1);
        for (int i = 1; i < N; i++) {
            Set<Integer> tmp = dp.keySet();
            int max_v = 0;
            for (int e : tmp) {
                if (e < arr[i] && max_v < dp.get(e)) {
                    max_v = dp.get(e);
                }
            }
            dp.put(arr[i], max_v + 1);
        }
        int cnt = 0;
        for (int e : dp.values()) {
            if (cnt < e) {
                cnt = e;
            }
        }

        System.out.println(cnt);
    }
}
