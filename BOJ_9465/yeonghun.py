import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(2)]

    if n == 1:
        print(max(data[0][0], data[1][0]))
        continue
    # 초기 조건
    data[0][1] += data[1][0]
    data[1][1] += data[0][0]

    # dp
    for j in range(2, n):
        data[0][j] += max(data[1][j - 1], data[1][j - 2])
        data[1][j] += max(data[0][j - 1], data[0][j - 2])

    print(max(data[0][n - 1], data[1][n - 1]))
