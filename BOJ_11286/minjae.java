import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive_pq = new PriorityQueue<>();
        PriorityQueue<Integer> negative_pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (!positive_pq.isEmpty() && !negative_pq.isEmpty()) {
                    int negative = negative_pq.peek();

                    if (Math.abs(negative) <= positive_pq.peek()) {
                        sb.append(negative_pq.poll());
                    } else {
                        sb.append(positive_pq.poll());
                    }
                } else if (!positive_pq.isEmpty()) {
                    sb.append(positive_pq.poll());
                } else if (!negative_pq.isEmpty()) {
                    sb.append(negative_pq.poll());
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else {
                if (x == Math.abs(x)) {
                    positive_pq.add(x);
                } else {
                    negative_pq.add(x);
                }
            }
        }

        System.out.println(sb);
    }
}
