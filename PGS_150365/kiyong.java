import java.util.*;

class Solution {
    static int[] dx = new int[]{1, 0, 0, -1};
    static int[] dy = new int[]{0, -1, 1, 0};
    static String[] dchar = new String[]{"d", "l", "r", "u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        boolean isPossible = false;
        String[][] paths = new String[n + 1][m + 1];
        paths[x][y] = "";
        String now_path = "";
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            now_path = paths[now_x][now_y];
            
            if (now_path.length() > k) {
                break;
            }
            
            if (now_x == r && now_y == c && now_path.length() == k) {
                isPossible = true;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int next_x = now_x + dx[d];
                int next_y = now_y + dy[d];
                
                if (next_x > 0 && next_x <= n && next_y > 0 && next_y <= m) {
                    if (paths[next_x][next_y] == null || (
                            paths[next_x][next_y] != null && 
                            paths[next_x][next_y].length() < now_path.length()
                            )
                       ) {
                        q.offer(new int[]{next_x, next_y});
                        paths[next_x][next_y] = now_path + dchar[d];
                    }
                }
            }
        }
        
        if (isPossible) {
            sb.append(now_path);
        } else {
            sb.append("impossible");
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}
