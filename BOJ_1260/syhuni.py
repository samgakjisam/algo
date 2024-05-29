from collections import deque
import sys
input = sys.stdin.readline

def dfs(node):
    dfs_result.append(node)
    visited[node] = True
    for a in sorted(arr[node]):
        if not visited[a]:
            dfs(a)


def bfs(start):
    bfs_visited = [False] * (N + 1)
    que = deque()
    que.append(start)
    bfs_visited[start] = True

    while que:
        node = que.popleft()
        bfs_result.append(node)
        for a in sorted(arr[node]):
            if not bfs_visited[a]:
                que.append(a)
                bfs_visited[a] = True


N, M, V = map(int, input().split())
arr = [[] for _ in range(N+1)]  # 인접 리스트
for _ in range(M):
    u, v = map(int, input().split())
    arr[u].append(v)
    arr[v].append(u)  # 양방향

visited = [False] * (N + 1)
dfs_result = []
dfs(V)
bfs_result = []
bfs(V)
for node in dfs_result:
    print(node, end=' ')
print()
for node in bfs_result:
    print(node, end=' ')
