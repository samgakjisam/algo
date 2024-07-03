import java.io.*;
import java.util.*;

public class boj_7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    if (map.containsKey(num)) {
                        int cnt = map.get(num);
                        map.replace(num, ++cnt);
                    } else {
                        map.put(num, 1);
                    }
                } else {
                    if (!map.isEmpty()) {
                        int key;

                        if (num == 1) {
                            key = map.lastKey();
                        } else {
                            key = map.firstKey();
                        }

                        int cnt = map.get(key);
                        map.replace(key, --cnt);

                        if (map.get(key) == 0) {
                            map.remove(key);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            sb.append("\n");
        } // tc for

        System.out.println(sb);
    }
}
