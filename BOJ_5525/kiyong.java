import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int cnt = 0;
        int i = 0;

        while (i < M-2) {
            int tmp = 0;
            if (S.charAt(i) == 'I') {
                while (i < M-2 && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    tmp++;
                    i = i+2;
                    if (tmp >= N) {
                        cnt++;
                    }
                }
            }
            i++;
        }
        System.out.println(cnt);
    }
}
