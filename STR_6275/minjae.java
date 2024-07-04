import java.io.*;
import java.util.*;

public class Main {
    static int H;
    static int W;
    static boolean[][] senior_map;
    static boolean[][] my_map;
    static int s_dir;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] dir = {0, 1, 3};
    static String answer = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        senior_map = new boolean[H][W];
        my_map = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String temp = br.readLine();
            for (int j = 0; j < W; j++) {
                if (temp.charAt(j) == '#') {
                    senior_map[i][j] = true;
                }
            }
        }

        boolean isSearch = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (senior_map[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        int d_nr = nr + dr[k];
                        int d_nc = nc + dc[k];
            
                        if (d_nr >= 0 && d_nr < H && d_nc >= 0 && d_nc < W) {
                            if (senior_map[nr][nc] && senior_map[d_nr][d_nc] && !my_map[nr][nc] && !my_map[d_nr][d_nc]) {
                                s_dir = k;
                                my_map[i][j] = true;
                                my_map[nr][nc] = true;
                                my_map[d_nr][d_nc] = true;
                                answer = "A";
                                dfs(d_nr, d_nc, k);

                                boolean escape = false;
                                for (int l = 0; l < H; l++) {
                                    for (int m = 0; m < W; m++) {
                                        if (senior_map[l][m] != my_map[l][m]) {
                                            escape = true;
                                            break;
                                        }
                                    }

                                    if (escape) break;
                                    if (l == H-1) {
                                        isSearch = true;
                                        sb.append(i+1).append(" ").append(j+1).append("\n");
                                    }
                                }

                                if (escape) {
                                    for (int l = 0; l < H; l++) {
                                        for (int m = 0; m < W; m++) {
                                            my_map[l][m] = false;
                                        }
                                    }
                                }
                            }
                        }
                        if (isSearch) break;
                    }
                }
                if (isSearch) break;
            }
            if (isSearch) break;
        }

        switch (s_dir) {
            case 0 :
                sb.append("^");
                break;
            case 1 :
                sb.append(">");
                break;
            case 2 :
                sb.append("v");
                break;
            case 3 :
                sb.append("<");
                break;
        }
        sb.append("\n").append(answer);
        System.out.println(sb);
    }

    static void dfs(int s_row, int s_col, int cur_dir) {
        for (int i = 0; i < 3; i++) {
            int nr = s_row + dr[(cur_dir + dir[i]) % 4];
            int nc = s_col + dc[(cur_dir + dir[i]) % 4];
            int d_nr = nr + dr[(cur_dir + dir[i]) % 4];
            int d_nc = nc + dc[(cur_dir + dir[i]) % 4];
    
            if (d_nr >= 0 && d_nr < H && d_nc >= 0 && d_nc < W) {
                if (senior_map[nr][nc] && senior_map[d_nr][d_nc] && !my_map[nr][nc] && !my_map[d_nr][d_nc]) {
                    my_map[nr][nc] = true;
                    my_map[d_nr][d_nc] = true;
                    
                    if (i == 0) {
                        answer += "A";
                    } else if (i == 1) {
                        answer += "RA";
                    } else if (i == 2) {
                        answer += "LA";
                    }
                    
                    dfs(d_nr, d_nc, (cur_dir + dir[i]) % 4);
                }
            }
        }
        
    }
}