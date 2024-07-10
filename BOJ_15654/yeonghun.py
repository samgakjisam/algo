import sys
input = sys.stdin.readline


def dfs(cnt):
    if cnt == m:
        print(' '.join(map(str, pick)))

    for num in nums:
        if visited[num]:
            continue

        pick.append(num)
        visited[num] = 1
        dfs(cnt + 1)
        pick.pop()
        visited[num] = 0


n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
pick = []
visited = [0] * 10000
dfs(0)
