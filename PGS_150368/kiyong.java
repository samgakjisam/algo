class Solution {
    static int user_num, emoticon_num, max_service, max_price;
    static int[] sale_percent, user_price;
    static boolean[] user_service;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        user_num = users.length;
        emoticon_num = emoticons.length;
        sale_percent = new int[emoticon_num];
        user_price = new int[user_num];
        user_service = new boolean[user_num];
        max_service = 0;
        max_price = 0;
        dfs(0, users, emoticons);
        answer[0] = max_service;
        answer[1] = max_price;

        return answer;
    }
    static void dfs(int n, int[][] users, int[] emoticons) {
        if (n == emoticon_num) {
            int tmp_service = 0;
            int tmp_price = 0;
            for (int i = 0; i < user_num; i++) {
                if (user_price[i] >= users[i][1]) {
                    tmp_service++;
                } else {
                    tmp_price += user_price[i];
                }
            }
            if (max_service < tmp_service) {
                max_service = tmp_service;
                max_price = tmp_price;
            } else if (max_service == tmp_service && max_price < tmp_price) {
                max_price = tmp_price;
            }
            return;
        }
        for (int sale : new int[] {10, 20, 30, 40}) {
            for (int i = 0; i < user_num; i++) {
                if (users[i][0] <= sale) {
                    user_price[i] += emoticons[n] * (100 - sale) / 100;
                }
            }
            dfs(n + 1, users, emoticons);
            for (int i = 0; i < user_num; i++) {
                if (users[i][0] <= sale) {
                    user_price[i] -= emoticons[n] * (100 - sale) / 100;
                }
            }
        }
    }
}
