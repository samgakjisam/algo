import sys
from collections import deque
input = sys.stdin.readline


# 일반 구역 bfs
def bfs(data, n, color):
    while que:
        i, j = que.popleft()
        for di, dj in [(0,1), (1,0), (0,-1), (-1,0)]:
            ni, nj = i + di, j + dj
            if 0 <= ni < n and 0 <= nj < n and data[ni][nj] == color:
                que.append((ni, nj))
                data[ni][nj] = 0


# 일반 구역 세는 함수
def count_area(data, n):
    cnt = 0
    for i in range(n):
        for j in range(n):
            if data[i][j] in color_set:
                cnt += 1
                que.append((i, j))
                bfs(data, n, data[i][j])
    return cnt


# 적록색약 bfs
def rg_bfs(data, n, color):
    while que:
        i, j = que.popleft()
        for di, dj in [(0,1), (1,0), (0,-1), (-1,0)]:
            ni, nj = i + di, j + dj
            if color in rg_set:
                if 0 <= ni < n and 0 <= nj < n and data[ni][nj] in rg_set:
                    que.append((ni, nj))
                    data[ni][nj] = 0
            else:
                if 0 <= ni < n and 0 <= nj < n and data[ni][nj] == color:
                    que.append((ni, nj))
                    data[ni][nj] = 0


# 적록색약 구역 세는 함수
def rg_count_area(data, n):
    cnt = 0
    for i in range(n):
        for j in range(n):
            if data[i][j] in color_set:
                cnt += 1
                que.append((i, j))
                rg_bfs(data, n, data[i][j])
    return cnt


N = int(input())
data = [list(input().strip()) for _ in range(N)]
copied_data = [row[:] for row in data]
que = deque()
color_set = ('R', 'G', 'B')
rg_set = ('R', 'G')
print(count_area(data, N), rg_count_area(copied_data, N))
