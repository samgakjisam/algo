package BOJ_1920;

import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = Arrays.stream(arr).sorted().toArray();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int low = 0;
            int high = N - 1;
            int answer = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] < tmp) {
                    low = mid + 1;
                } else if (arr[mid] > tmp) {
                    high = mid - 1;
                } else {
                    answer = 1;
                    break;
                }
            }
            if (answer == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
