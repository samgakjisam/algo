import java.util.*;

class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] direction = {"d", "l", "r", "u"};
    static String[][] maze;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        maze = new String[n+1][m+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        maze[x][y] = "";
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (maze[cur[0]][cur[1]].length() == k) {
                if (cur[0] == r && cur[1] == c) {
                    answer = maze[cur[0]][cur[1]];
                    break;
                } else {
                    continue;
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                    if (maze[nr][nc] == null || (maze[nr][nc] != null && maze[nr][nc].length() <= maze[cur[0]][cur[1]].length())) {
                        q.add(new int[] {nr, nc});
                        maze[nr][nc] = maze[cur[0]][cur[1]] + direction[i];
                    }
                }
            }
        }
        
        if (answer == "") {
            answer = "impossible";
        }
        
        return answer;
    }
}