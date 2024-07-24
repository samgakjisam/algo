import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    for j in range(3):
        data[i][j] += min(data[i - 1][(j + 1) % 3], data[i - 1][(j + 2) % 3])

print(min(data[n - 1]))