import java.io.*;
import java.util.*;

public class kiyong {
    static int N;
    static int M;
    static int[] board;
    static int[] cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[101];
        for (int i = 0; i < 101; i++) {
            board[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ladder_s = Integer.parseInt(st.nextToken());
            int ladder_e = Integer.parseInt(st.nextToken());
            board[ladder_s] = ladder_e;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int snake_s = Integer.parseInt(st.nextToken());
            int snake_e = Integer.parseInt(st.nextToken());
            board[snake_s] = snake_e;
        }
        cnt = new int[101];
        turn();
        System.out.println(cnt[100]);
    }

    static void turn() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int now; // 현재 위치
        while (!q.isEmpty()) {
            if (cnt[100] != 0) {
                break;
            }
            now = q.poll();
            for (int i = 1; i < 7; i++) {
                if (now + i <= 100 && cnt[board[now + i]] == 0) {
                    cnt[board[now + i]] = cnt[now]+1;
                    q.offer(board[now + i]);
                }
            }
        }
    }
}
