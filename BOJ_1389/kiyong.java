import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> kb = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!kb.containsKey(a)) {
                kb.put(a, new ArrayList<>());
            }
            if (!kb.containsKey(b)) {
                kb.put(b, new ArrayList<>());
            }
            kb.get(a).add(b);
            kb.get(b).add(a);
        }

        int min_v = 60000;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int[] met = new int[N];
            met[i] = 1;
            for (int j : kb.get(i+1)) {
                q.offer(j);
                met[j-1] = 1;
            }
            while (!q.isEmpty()) {
                int tmp = q.poll();
                for (int j : kb.get(tmp)) {
                    if (met[j - 1] == 0) {
                        met[j-1] = met[tmp-1] + 1;
                        q.offer(j);
                    }
                }
            }
            if (min_v > Arrays.stream(met).sum()-1) {
                min_v = Arrays.stream(met).sum()-1;
                ans = i+1;
            }
        }
        System.out.println(ans);
    }
}
