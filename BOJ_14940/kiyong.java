import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] ans = new int[n][m];
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                    ans[i][j] = 0;
                } else if (map[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        int x, y, nx, ny;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int[] dd : d) {
                nx = x+dd[0];
                ny = y+dd[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1 && ans[nx][ny] == -1) {
                    q.add(new int[]{nx, ny});
                    ans[nx][ny] = ans[x][y] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
