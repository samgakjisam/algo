import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class kiyong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int ans = 1;
        int tmp;
        int i = N-1;
        tmp = arr[i][0];
        while (i>=0) {
            if (arr[i][1] <= tmp) {
                ans++;
                tmp = arr[i][0];
            }
            i--;
        }
        System.out.println(ans);
    }
}
