import java.util.*;

class Solution {
    static int[][] result;
    static int[] sales = {10, 20, 30, 40};
    static int result_idx = 0;
    static int[][] emoticons_two;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int length = 1;
        for (int i = 0; i < emoticons.length; i++) {
            length *= 4;
        }
        result = new int[length][2];
        emoticons_two = new int[emoticons.length][2];
        
        find_result(users, emoticons, 0);
        Arrays.sort(result, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        
        return result[0];
    }
    
    static void find_result(int[][] users, int[] emoticons, int idx) {
        if (idx == emoticons.length) {
            // 결과값 계산
            for (int i = 0; i < users.length; i++) {
                int price = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] > emoticons_two[j][0]) {
                        continue;
                    }
                    
                    price += emoticons_two[j][1] * (100 - emoticons_two[j][0]) / 100;
                }
                
                if (users[i][1] <= price) {
                    result[result_idx][0]++;
                } else {
                    result[result_idx][1] += price;
                }
            }
            result_idx++;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            emoticons_two[idx][0] = sales[i];
            emoticons_two[idx][1] = emoticons[idx];
            find_result(users, emoticons, idx+1);
        }
    }
}