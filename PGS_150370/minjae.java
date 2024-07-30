import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    static StringTokenizer st;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 유효기간 해싱
        map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        // 개인정보 2차원 배열
        String[][] privacies_two = new String[privacies.length][2];
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            privacies_two[i][0] = st.nextToken();
            privacies_two[i][1] = st.nextToken();
        }
        
        // 폐기 체크용 배열
        boolean[] visited = new boolean[privacies.length];
        int cnt = 0;
        for (int i = 0; i < privacies.length; i++) {
            if (check(today, privacies_two[i][0], privacies_two[i][1])) {
                visited[i] = true;
                cnt++;
            }
        }
        
        // 정답 출력
        int[] answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                answer[idx] = i+1;
                idx++;
            }
        }
        
        return answer;
    }
    
    static boolean check(String today, String privacy, String order) {
        // 오늘 날짜 배열로
        st = new StringTokenizer(today, ".");
        int[] today_arr = new int[3];
        for (int i = 0; i < 3; i++) {
            today_arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 개인정보 날짜 배열로
        st = new StringTokenizer(privacy, ".");
        int[] privacy_arr = new int[3];
        for (int i = 0; i < 3; i++) {
            privacy_arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 보관 등급의 날짜를 개인정보 날짜와 계산
        int order_day = map.get(order);
        privacy_arr[0] += order_day / 12;
        privacy_arr[1] += order_day % 12;
        
        // 개인정보 월이 12를 넘어가면 연을 늘리기
        if (privacy_arr[1] > 12) {
            privacy_arr[0]++;
            privacy_arr[1] -= 12;
        }
        
        // 개인정보 보관 날짜가 지났는지 판단
        if (today_arr[0] > privacy_arr[0]) {
            return true;
        } else if (today_arr[0] < privacy_arr[0]) {
            return false;
        } else {
            if (today_arr[1] > privacy_arr[1]) {
                return true;
            } else if (today_arr[1] < privacy_arr[1]) {
                return false;
            } else {
                if (today_arr[2] < privacy_arr[2]) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}