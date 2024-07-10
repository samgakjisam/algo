'''
사 => 사
2 * 3 + 1 * 2 = 3 * 3 - 1
사 => 삼
2 * 4 + 1 * 3 = 3 * 4 - 1
삼 => 사
3 * 3 + 1 * 2 = 4 * 3 - 1
삼 => 삼
3 * 4 + 1 * 3 = 4 * 4 - 1
맨 오른쪽이 마름모인 개수를 세어 나가야함
'''

def solution(n, tops):
    dp = [0] * (n + 1)
    dp[0] = 1
    if tops[0] == 0:
        dp[1] = 3
    else:
        dp[1] = 4
    for i in range(1, n):
        if tops[i] == 0:
            dp[i + 1] = dp[i] * 3 - dp[i - 1]
        else:
            dp[i + 1] = dp[i] * 4 - dp[i - 1]
    answer = dp[n] % 10007
    return answer