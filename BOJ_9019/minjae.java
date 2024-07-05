import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            int B = Integer.parseInt(st.nextToken());

            int[] B_arr = number_change_array(B);
            for (int i = 0; i < 10000; i++) {
                visited[i] = false;
            }
            bfs(A, B_arr);
        } // tc for

        System.out.println(sb);
    }

    static void bfs(String num, int[] arr) {
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[] {num, ""});
        visited[Integer.parseInt(num)] = true;

        while (!q.isEmpty()) {
            String[] current = q.poll();
            int cur_num = Integer.parseInt(current[0]);
            int[] temp = number_change_array(cur_num);

            if (number_equal(temp, arr)) {
                sb.append(current[1]).append("\n");
                break;
            }

            String order_L = L(cur_num);
            if (!visited[Integer.parseInt(order_L)]) {
                q.add(new String[] {order_L, current[1] + "L"});
                visited[Integer.parseInt(order_L)] = true;
            }

            String order_R = R(cur_num);
            if (!visited[Integer.parseInt(order_R)]) {
                q.add(new String[] {order_R, current[1] + "R"});
                visited[Integer.parseInt(order_R)] = true;
            }

            String order_D = D(cur_num);
            if (!visited[Integer.parseInt(order_D)]) {
                q.add(new String[] {order_D, current[1] + "D"});
                visited[Integer.parseInt(order_D)] = true;
            }

            String order_S = S(cur_num);
            if (!visited[Integer.parseInt(order_S)]) {
                q.add(new String[] {order_S, current[1] + "S"});
                visited[Integer.parseInt(order_S)] = true;
            }
        }
    }

    static String D(int num) {
        return "" + num * 2 % 10000;
    }

    static String S(int num) {
        int answer = num - 1;

        if (answer < 0) {
            answer += 10000;
        }

        return "" + answer;
    }

    static String L(int num) {
        int[] arr = number_change_array(num);
        return "" + arr[1] + arr[2] + arr[3] + arr[0];
    }

    static String R(int num) {
        int[] arr = number_change_array(num);
        return "" + arr[3] + arr[0] + arr[1] + arr[2];
    }

    static int[] number_change_array(int num) {
        int[] array = new int[4];
        array[0] = num / 1000;
        array[1] = (num % 1000) / 100;
        array[2] = (num % 100) / 10;
        array[3] = num % 10;

        return array;
    }

    static boolean number_equal(int[] arr1, int[] arr2) {
        for (int i = 0; i < 4; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
