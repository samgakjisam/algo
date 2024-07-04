import java.io.*;
import java.util.*;

public class Main {

    static int H;
    static int W;
    static boolean[][] vis;
    static String[] maps;
    static int[] dh = new int[]{0, 1, 0, -1};
    static int[] dw = new int[]{1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    static String dirChar;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        maps = new String[H];
        vis = new boolean[H][W];
        boolean startFound = false;
        int startH = 0;
        int startW = 0;
        int dir = 0;
        
        for (int h = 0; h < H; h++) {
            maps[h] = br.readLine();
        }
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (!startFound && maps[h].charAt(w) == '#') {
                    int cnt = 0;
                    dir = 0;
                    for (int d = 0; d < 4; d++) {
                        int nh = h + dh[d];
                        int nw = w + dw[d];
                        if (0 <= nh && nh < H && 0 <= nw && nw < W && maps[nh].charAt(nw) == '#') {
                            cnt++;
                            dir = d;
                        }
                    }
                    if (cnt == 1) {
                        startH = h;
                        startW = w;
                        startFound = true;
                    }
                }
            }
        }
        sb.append(startH + 1).append(" ").append(startW + 1).append("\n");
        String directionMark = "";
        switch (dir) {
            case 0:
                directionMark = ">";
                break;
            case 1:
                directionMark = "v";
                break;
            case 2:
                directionMark = "<";
                break;
            case 3:
                directionMark = "^";
                break;
        }
        sb.append(directionMark).append("\n");
        dfs(startH, startW, dir);
        System.out.println(sb);
    }
    static void dfs(int h, int w, int dir){
        vis[h][w] = true;
        for (int d = 0; d < 4; d++) {
            int nh = h + dh[d];
            int nw = w + dw[d];
            if (0 <= nh && nh < H && 0 <= nw && nw < W && maps[nh].charAt(nw) == '#' && !vis[nh][nw]) {
                switch ((dir - d)%4) {
                    case 1:
                    case -3:
                        dirChar = "LA";
                        break;
                    case 0:
                        dirChar = "A";
                        break;
                    case -1:
                    case 3:
                        dirChar = "RA";
                        break;
                };
                sb.append(dirChar);
                vis[nh][nw] = true;
                dfs(h + 2 * dh[d], w + 2 * dw[d], d);
                break;
            }
        }
    }
}
