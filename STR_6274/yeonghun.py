import sys
from collections import deque

input = sys.stdin.readline

signs = {
    1: [[-1, 0], [0, 1], [1, 0]], 2: [[0, -1], [-1, 0], [0, 1]], 3: [[1, 0], [0, -1], [-1, 0]],
    4: [[0, 1], [1, 0], [0, -1]],
    5: [[-1, 0], [0, 1]], 6: [[0, -1], [-1, 0]], 7: [[1, 0], [0, -1]], 8: [[0, 1], [1, 0]],
    9: [[0, 1], [1, 0]], 10: [[-1, 0], [0, 1]], 11: [[0, -1], [-1, 0]], 12: [[1, 0], [0, -1]]
}

from_dir = {'L': [1, 5, 9], 'D': [2, 6, 10], 'R': [3, 7, 11], 'U': [4, 8, 12]}


def to_dir(arr):
    if arr == [-1, 0]:
        return 'D'
    elif arr == [0, 1]:
        return 'L'
    elif arr == [1, 0]:
        return 'U'
    elif arr == [0, -1]:
        return 'R'


N, T = map(int, input().split())
data = [[list(map(int, input().split())) for _ in range(N)] for _ in range(N)]
# print(data)
visited = [[0] * N for _ in range(N)]

que = deque()
que.append([0, 0, 'D', 0])
visited[0][0] = 1
while que:
    i, j, d, t = que.popleft()
    if t >= T:
        continue
    now_sign = data[i][j][t % 4]  # 현재 신호
    if now_sign in from_dir[d]:  # 현재 교차로의 현재 신호가 진입한 방향의 신호라면
        for sign in signs[now_sign]:
            di, dj = sign
            ni, nj = i + di, j + dj
            if 0 <= ni <= N - 1 and 0 <= nj <= N - 1:
                que.append([ni, nj, to_dir([di, dj]), t + 1])
                visited[ni][nj] = 1

ans = 0
for i in range(N):
    for j in range(N):
        ans += visited[i][j]

print(ans)