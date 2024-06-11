import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tanghulu = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max_cnt = 0;
        int kind = 0;

        int[] fruits = new int[10];
        while (right < N) {
            if (fruits[tanghulu[right]] == 0) {
                kind++;
            }
            fruits[tanghulu[right]]++;

            if (kind > 2) {
                if (--fruits[tanghulu[left]] == 0) {
                    kind--;
                }
                left++;
            } else {
                max_cnt = Math.max(max_cnt, right - left + 1);
            }
            right++;
        }

        System.out.println(max_cnt);
    }
}
