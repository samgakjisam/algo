import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer>[] adj = (Set<Integer>[]) new Set[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new HashSet<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] p = new int[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (Integer e : adj[tmp]) {
                if (p[e] == 0) {
                    p[e] = tmp;
                    q.offer(e);
                }
            }
        }
        for (int i = 2; i < N+1; i++) {
            System.out.println(p[i]);
        }
    }
}
