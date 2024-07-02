import java.io.*;
import java.util.*;

class Number {
    int value;

    public Number(int value) {
        this.value = value;
    }
}

class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number o1, Number o2) {
        if (Math.abs(o1.value) == Math.abs(o2.value)) {
            return o1.value - o2.value;
        } else {
            return Math.abs(o1.value) - Math.abs(o2.value);
        }
    }
}

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Number> pq = new PriorityQueue<>(1, new NumberComparator());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp != 0) {
                pq.offer(new Number(tmp));
            } else {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    Number n = pq.poll();
                    sb.append(n.value);
                }
                if (i < N - 1) {
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
