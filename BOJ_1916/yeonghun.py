import sys
from heapq import heappop, heappush
input = sys.stdin.readline


def dijkstara(graph, start, final):
    que = [[0, start]]
    dist = [float("inf")] * len(graph)
    dist[start] = 0
    visited = [False] * (N + 1)

    while que:
        # 현재 사용 가능한 간선 중 가중치가 가장 작은 간선 가져오기
        w1, visit = heappop(que)
        # 이미 계산한 노드는 패스
        if visited[visit]:
            continue
        visited[visit] = True
        # visit 노드에 인접한 route 탐색
        for route, w2 in graph[visit]:
            # start -w1-> visit -w2-> route 경로 거리가 dist[route]보다 작으면 업데이트
            if (w3 := w1 + w2) < dist[route]:
                heappush(que, [w3, route])
                dist[route] = w3
    return dist[final]


N = int(input())  # 노드 개수
M = int(input())  # 간선 개수
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v, w = map(int, input().split())  # 출발, 도착, 가중치
    graph[u].append([v, w])
start, final = map(int, input().split())
ans = dijkstara(graph, start, final)
print(ans)