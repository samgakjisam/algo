import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int step = x;
            int gcd = getGCD(M, N);
            boolean is_search = false;

            while (step <= M*N/gcd) {
                int y_prime = step % N;
                if (y_prime == 0) {
                    y_prime = N;
                }

                if (y_prime == y) {
                    is_search = true;
                    break;
                }
                step += M;
            }

            if (!is_search) {
                sb.append("-1");
            } else {
                sb.append(step);
            }
            sb.append("\n");
        } // tc for

        System.out.println(sb);
    }

    static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
