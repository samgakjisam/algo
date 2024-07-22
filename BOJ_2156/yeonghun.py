import sys
input = sys.stdin.readline

n = int(input())
wines = []
for _ in range(n):
    wines.append(int(input()))
dp = [0] * 10000
max_v = 0
if n == 1:
    max_v = wines[0]
elif n == 2:
    max_v = wines[0] + wines[1]
else:
    dp[0] = wines[0]
    dp[1] = wines[0] + wines[1]
    dp[2] = max(dp[1], dp[0] + wines[2], wines[1] + wines[2])
    if n > 3:
        for i in range(3, n):
            dp[i] = max(dp[i-1], dp[i-2] + wines[i], dp[i-3] + wines[i-1] + wines[i])
    max_v = dp[n-1]

print(max_v)

print(max_v)