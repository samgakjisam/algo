import sys
from collections import deque
input = sys.stdin.readline


N, M = map(int, input().split())
board = [0] * 101
ladder_dict = {}
for _ in range(N + M):
    x, y = map(int, input().split())
    ladder_dict[x] = y
que = deque([1])
while que:
    now = que.popleft()
    cnt = board[now]
    for i in range(6, 0, -1):
        next_i = now + i
        if next_i >= 101:
            continue
        if ladder_dict.get(next_i):  # 뱀 혹은 사다리라면
            next_i = ladder_dict.get(next_i)
        if board[next_i] == 0 or board[next_i] >= cnt + 2:
            que.append(next_i)
            board[next_i] = cnt + 1
print(board[100])