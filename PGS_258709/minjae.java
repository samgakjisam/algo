import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] all_dice;
    static int[][] A_dice;
    static int[][] B_dice;
    static HashMap<int[], int[]> map = new HashMap<>();
    
    public int[] solution(int[][] dice) {
        int n = dice.length;
        visited = new boolean[n];
        visited[0] = true;
        
        all_dice = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                all_dice[i][j] = dice[i][j];
            }
        }
        
        A_dice = new int[n/2][6];
        B_dice = new int[n/2][6];
        comb(n, 1, n/2 - 1);
        
        int[] answer = {};
        return answer;
    }
    
    static void comb(int n, int start, int r) {
        if (r == 0) {
            int A_row = 0;
            int B_row = 0;
            int[] idx_arr = new int[n/2];
            int idx = 0;
            
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    idx_arr[idx] = i;
                    for (int j = 0; j < 6; j++) {
                        A_dice[A_row][j] = all_dice[i][j];
                    }
                    A_row++;
                    idx++;
                } else {
                    for (int j = 0; j < 6; j++) {
                        B_dice[B_row][j] = all_dice[i][j];
                    }
                    B_row++;
                }
            }
            
            map.put(idx_arr, new int[] {0, 200, 0});
            System.out.println(map.get(idx_arr)[1]);
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(n, i+1, r-1);
            visited[i] = false;
        }
    }
    
    // static 
}