import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] tops = new int[N];
        HashMap<Integer, Integer> top_height = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
            top_height.put(tops[i], i+1);
        }

        int[] lasers = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                int prev_top = stack.peek();

                if (prev_top > tops[i]) {
                    lasers[i] = top_height.get(prev_top);
                    stack.add(tops[i]);
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                stack.add(tops[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(lasers[i]).append(" ");
        }
        System.out.println(sb);
    }
}
