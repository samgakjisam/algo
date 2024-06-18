import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0;
        int idx = 0;
        while (idx < M-2) {
            if (S.charAt(idx) == 'I') {
                int temp = 0;
                while (idx < M-2) {
                    if (idx+1 < M-1 && S.charAt(idx+1) == 'O' && idx+2 < M && S.charAt(idx+2) == 'I') {
                        temp++;
                        idx += 2;

                        if (temp >= N) {
                            cnt++;
                        }
                    } else {
                        break;
                    }
                }
            }
            idx++;
        }

        System.out.println(cnt);
    }
}
