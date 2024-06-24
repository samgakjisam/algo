import java.io.*;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                } else if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int max_v = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    arr[nx][ny] = arr[tmp[0]][tmp[1]] + 1;
                    max_v = arr[nx][ny];
                    cnt--;
                }
            }
        }
        if (cnt > 0) {
            System.out.println(-1);
        } else {
            if (max_v == 0) {
                System.out.println(0);
            } else {
                System.out.println(max_v - 1);
            }
        }
    }
}
