import sys
input = sys.stdin.readline


def dfs(i, j, next_pos_idx):
    global ans
    if (i + 1, j + 1) in visit_pos[1:]:
        if (i + 1, j + 1) == visit_pos[next_pos_idx]:  # 이번 방문 지점 맞으면
            if next_pos_idx == m - 1:  # 정답 조건
                ans += 1
                return
            else:  # 다음 방문 지점 인덱스 계산
                next_pos_idx += 1
        else:  # 이번 차례 방문 지점이 아니면
            return

    for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
        ni, nj = i + di, j + dj
        if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] == 0:
            grid[ni][nj] = 1
            # print(ni, nj)
            dfs(ni, nj, next_pos_idx)
            grid[ni][nj] = 0


n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
visit_pos = [tuple(map(int, input().split())) for _ in range(m)]
ans = 0
si, sj = visit_pos[0]
grid[si - 1][sj - 1] = 1
dfs(si - 1, sj - 1, 1)
print(ans)