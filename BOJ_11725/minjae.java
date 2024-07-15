import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] trees;
    static ArrayList<ArrayList<Integer>> roads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        trees = new int[N+1];
        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            roads.get(first).add(second);
            roads.get(second).add(first);
        }

        bfs();
        for (int i = 2; i <= N; i++) {
            sb.append(trees[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        trees[1] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : roads.get(node)) {
                if (trees[child] == 0) {
                    q.add(child);
                    trees[child] = node;
                }
            }
        }
    }
}
