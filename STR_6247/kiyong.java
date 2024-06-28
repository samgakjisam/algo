import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Integer[] cars = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cars[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cars);
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            h.put(cars[i], i * (n - i - 1));
        }
        int tmp;
        for (int i = 0; i < q; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (h.containsKey(tmp)) {
                sb.append(h.get(tmp));
            } else {
                sb.append(0);
            }
            if (i < q-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
