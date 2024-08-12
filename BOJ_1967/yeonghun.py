import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)


def dfs(node, dist, visited):
    global max_dist, max_dist_node
    for nxt_node, nd in tree[node]:
        if not visited[nxt_node]:
            dist += nd
            if max_dist < dist:
                max_dist = dist
                max_dist_node = nxt_node
            visited[nxt_node] = 1
            dfs(nxt_node, dist, visited)
            dist -= nd


n = int(input())
tree = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u, v, d = map(int, input().split())
    tree[u].append([v, d])
    tree[v].append([u, d])
# print(tree)
max_dist_node = 0
max_dist = 0

# 루트에서 거리 가장 먼 곳 찾기
visited = [0] * (n + 1)
visited[1] = 1
dfs(1, 0, visited)
# print(max_dist, max_dist_node)

# 트리의 지름 찾기
new_visited = [0] * (n + 1)
new_visited[max_dist_node] = 1
dfs(max_dist_node, 0, new_visited)
print(max_dist)
