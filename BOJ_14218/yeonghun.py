import sys
from collections import deque

input = sys.stdin.readline


def bfs():
    que = deque()
    visited = [-1] * (n + 1)

    visited[1] = 0
    que.append(1)
    while que:
        now = que.popleft()
        for nxt in graph[now]:
            if visited[nxt] == -1:
                que.append(nxt)
                visited[nxt] = visited[now] + 1

    print(' '.join(map(str, visited[1:])))


n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

q = int(input())
for _ in range(q):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
    bfs()
