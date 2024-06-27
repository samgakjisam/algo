import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        StringTokenizer st;
        int length = friends.length;
        
        // key를 이름, value 값을 인덱스로 매핑하기
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(friends[i], i);
        }
        
        // 사람에 따른 2차원 배열을 만들어서 row는 선물 준 사람, col은 받은 사람으로 갯수 채우기
        int[][] gifts_two_dimen = new int[length][length];
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i], " ");
            
            String from = st.nextToken();
            String to = st.nextToken();
            gifts_two_dimen[map.get(from)][map.get(to)]++;
        }
        
        // 선물 지수
        int[] gift_points = new int[length];
        for (int i = 0; i < length; i++) {
            int give_point = 0;
            int get_point = 0;
            
            for (int j = 0; j < length; j++) {
                give_point += gifts_two_dimen[i][j];
                get_point +=  gifts_two_dimen[j][i];
            }
            
            gift_points[i] = give_point - get_point;
        }
        
        // 내년 선물
        int[] next_gifts = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (gifts_two_dimen[i][j] > gifts_two_dimen[j][i]) {
                    next_gifts[i]++;
                } else if (gifts_two_dimen[i][j] < gifts_two_dimen[j][i]) {
                    next_gifts[j]++;
                } else {
                    if (gift_points[i] > gift_points[j]) {
                        next_gifts[i]++;
                    } else if (gift_points[i] < gift_points[j]) {
                        next_gifts[j]++;
                    }
                }
            }
        }
        
        // 최댓값
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, next_gifts[i]);
            // System.out.print(next_gifts[i] + " ");
        }
        return max;
    }
}