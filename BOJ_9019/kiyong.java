import java.io.*;
import java.util.*;

public class BOJ_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new int[10000];
            dslr = new int[4];
            q = new LinkedList<>();

            DSLR_bfs(A, B);

            String ans = Integer.toString(visited[B]);
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < ans.length(); j++) {
                switch (ans.charAt(j)) {
                    case '1':
                        result.append("D");
                        break;
                    case '2':
                        result.append("S");
                        break;
                    case '3':
                        result.append("L");
                        break;
                    case '4':
                        result.append("R");
                        break;
                }
            }
            System.out.println(result);
        }
    }

    static Queue<Integer> q;
    static int[] visited;
    static int[] dslr;

    static void DSLR_bfs(int a, int b) {
        q.offer(a);
        while (!q.isEmpty()) {
            if (visited[b] != 0) {
                break;
            }
            int tmp = q.poll();
            String tmpStr = Integer.toString(tmp);
            dslr[0] = (tmp * 2) % 10000;
            dslr[1] = (tmp == 0) ? 9999 : tmp-1;
            dslr[2] = (tmp < 10) ? tmp : Integer.parseInt(
                    tmpStr.substring(1) + tmpStr.charAt(0)
            );
            dslr[3] = (tmp < 10) ? tmp : Integer.parseInt(
                    tmpStr.charAt(tmpStr.length() - 1) + tmpStr.substring(0, tmpStr.length() - 1)
            );
            for (int i = 0; i < 4; i++) {
                if (visited[dslr[i]] == 0) {
                    q.offer(dslr[i]);
                    visited[dslr[i]] = visited[tmp] * 10 + i + 1;
                }
            }
        }
    }
}

// 3% 오답 코드.. 어디서 틀리는건지 진짜모르겠슴
