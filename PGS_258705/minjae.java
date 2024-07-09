// 영훈이의 풀이 참조 버전
class Solution {
    static private int mod = 10007;
    
    public long solution(int n, int[] tops) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        if (tops[0] == 0) {
            dp[1] = 3;
        } else {
            dp[1] = 4;
        }
        
        for (int i = 1; i < n; i++) {
            if (tops[i] == 0) {
                dp[i+1] = (dp[i] * 3 - dp[i-1]) % mod;
            } else {
                dp[i+1] = (dp[i] * 4 - dp[i-1]) % mod;
            }
            
            if (dp[i+1] < 0) {
                dp[i+1] += mod;
            }
        }

        return dp[n] % mod;
    }
}

// 어떤 대단하신 분의 풀이
class Solution {
    static private int mod = 10007;
    
    public long solution(int n, int[] tops) {
        long[][] dp = new long[n+1][2];
        dp[0][1] = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i+1][0] = (dp[i][0] + dp[i][1]) % mod;
            
            if (tops[i] == 0) {
                dp[i+1][1] = (dp[i][0] + dp[i][1] * 2) % mod;
            } else {
                dp[i+1][1] = (dp[i][0] * 2 + dp[i][1] * 3) % mod;
            }
        }

        return (dp[n][0] + dp[n][1]) % mod;
    }
}