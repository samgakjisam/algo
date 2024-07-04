import sys
from collections import deque

input = sys.stdin.readline


def find_start():
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if grid[i][j] == '#':
                temp = 0
                for di, dj in didj:
                    ni, nj = i + di, j + dj
                    if grid[ni][nj] == '#':
                        temp += 1

                if temp == 1:
                    return i, j


n, m = map(int, input().split())
grid = [['.'] + list(input().strip()) + ['.'] for _ in range(n)]
extra_grid = [['.'] * (m + 2)]
grid = extra_grid + grid + extra_grid
didj = [(0, 1), (1, 0), (0, -1), (-1, 0)]
dirs = '>v<^'
curr_dir_idx = -1
# print(grid)
si, sj = find_start()
print(si, sj)

# 첫 방향 찾기
for k in range(4):
    di, dj = didj[k]
    ni, nj = si + di, sj + dj
    if grid[ni][nj] == '#':
        curr_dir_idx = k
        print(dirs[k])
        break

# bfs
que = deque([(si, sj)])
grid[si][sj] = 0
command = ''
while que:
    i, j = que.popleft()
    for k in range(4):
        di, dj = didj[k]
        ni, nj = i + di, j + dj
        if grid[ni][nj] == '#':
            que.append((ni, nj))
            grid[ni][nj] = grid[i][j] + 1
            if grid[i][j] % 2:  # 현재 방문처리 홀수면 전진
                command += 'A'
                # print(grid[ni][nj], ni, nj)
            else:  # 짝수면 방향 전환 확인
                if (curr_dir_idx + 3) % 4 == k:  # 현재 방향 인덱스가 1 앞서면 좌회전
                    command += 'L'
                elif (curr_dir_idx + 1) % 4 == k:
                    command += 'R'
                    # print(grid[ni][nj], i, j)
                curr_dir_idx = k

print(command)