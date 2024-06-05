import sys
input = sys.stdin.read

K, N, *lines = list(map(int, input().split()))
start, end = 1, max(lines)
max_len = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    for line in lines:
        total += line // mid
    if total < N:
        end = mid - 1
    else:
        max_len = mid
        start = mid + 1

print(max_len)