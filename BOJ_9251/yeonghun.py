str1 = input()
str2 = input()

n, m = len(str1), len(str2)

dp = [[0] * (n + 1) for _ in range(m + 1)]

for i, c2 in enumerate(str2):
    for j, c1 in enumerate(str1):
        if c1 == c2:
            dp[i+1][j+1] = dp[i][j] + 1
        else:
            dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])

print(dp[m][n])