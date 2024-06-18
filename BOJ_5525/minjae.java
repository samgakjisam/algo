import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String P = "I";
        for (int i = 0; i < N; i++) {
            P += "OI";
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'I' && i + (2*N) < M) {
                String temp = S.substring(i, i+1+(2*N));
                if (temp.equals(P)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
