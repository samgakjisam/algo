from collections import deque
import sys
input = sys.stdin.readline


# 시작점 찾기
def find_start(arr):
    for u in range(N):
        for v in range(M):
            if arr[u][v] == 'I':
                return u, v


di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]
N, M = map(int, input().split())  # 세로, 가로
campus = [list(input().rstrip()) for _ in range(N)]
# print(campus)
visited = [[0] * M for _ in range(N)]

start_point = find_start(campus)
visited[start_point[0]][start_point[1]] = 1  # 시작점 방문 처리
que = deque([start_point])
count = 0

while que:
    i, j = que.popleft()
    for k in range(4):
        next_i, next_j = i + di[k], j + dj[k]
        if 0 <= next_i < N and 0 <= next_j < M:
            if visited[next_i][next_j] == 0 and campus[next_i][next_j] != 'X':
                if campus[next_i][next_j] == 'P':
                    count += 1
                que.append((next_i, next_j))
                visited[next_i][next_j] = 1

if count == 0:
    print('TT')
else:
    print(count)
