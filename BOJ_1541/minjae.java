import java.util.*;

public class boj_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.next();
        HashMap<Integer, String> min_expression = new HashMap<>();

        int key_idx = 1;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                key_idx++;
            } else {
                String num = "";
                if (!min_expression.containsKey(key_idx)) {
                    num += expression.charAt(i);
                } else {
                    num = min_expression.get(key_idx);
                    num += expression.charAt(i);
                }
                min_expression.put(key_idx, num);
            }
        }

        // map의 2번 키부터는 음수 값들
        int minus_num = 0;
        for (int i = 2; i <= key_idx; i++) {
            String temp = min_expression.get(i);
            String num = "";
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) != '+') {
                    num += temp.charAt(j);
                } else {
                    minus_num += Integer.parseInt(num);
                    num = "";
                }
            }
            minus_num += Integer.parseInt(num);
        }

        int first_num = 0;
        String first_expression = min_expression.get(1);
        String temp_num = "";
        for (int i = 0; i < first_expression.length(); i++) {
            if (first_expression.charAt(i) != '+') {
                temp_num += first_expression.charAt(i);
            } else {
                first_num += Integer.parseInt(temp_num);
                temp_num = "";
            }
        }
        first_num += Integer.parseInt(temp_num);

        System.out.println(first_num - minus_num);
    }
}
