def dfs(i):
    global cnt
    if i == n:
        cnt += 1
        return

    for k in range(n):
        for p in range(1, i + 1):
            if board[i - p][k]:
                break
            if k - p >= 0 and board[i - p][k - p]:
                break
            if k + p < n and board[i - p][k + p]:
                break
        else:
            board[i][k] = 1
            dfs(i + 1)
            board[i][k] = 0


n = int(input())
board = [[0] * n for _ in range(n)]
cnt = 0
for j in range(n):
    board[0][j] = 1
    dfs(1)
    board[0][j] = 0

print(cnt)
