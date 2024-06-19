import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())  # 행, 열
maze = [list(map(int, input().strip())) for _ in range(N)]

# bfs
que = deque([[0, 0]])
while que:
    i, j = que.popleft()
    for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
        ni, nj = i + di, j + dj
        if 0 <= ni < N and 0 <= nj < M and maze[ni][nj] == 1:
            maze[ni][nj] = maze[i][j] + 1  # 이동 칸 수 계산
            que.append([ni, nj])

print(maze[N-1][M-1])