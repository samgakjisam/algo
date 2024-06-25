import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            st = new StringTokenizer(temp, "[],");

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean natural = true;
            boolean isError = false;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    natural = !natural;
                } else if (p.charAt(i) == 'D') {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (natural) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    }
                }
            }

            if (isError) {
                sb.append("error");
            } else {
                sb.append("[");
                if (!dq.isEmpty()) {
                    if (natural) {
                        while (dq.size() > 1) {
                            sb.append(dq.pollFirst()).append(",");
                        }
                    } else {
                        while (dq.size() > 1) {
                            sb.append(dq.pollLast()).append(",");
                        }
                    }
                    sb.append(dq.poll());
                }
                sb.append("]");
            }
            sb.append("\n");
        } // tc for

        System.out.println(sb);
    }
}
