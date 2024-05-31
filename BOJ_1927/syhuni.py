import sys
import heapq
input = sys.stdin.readline

heap = []
N = int(input())
for _ in range(N):
    num = int(input())
    if num == 0:
        if heap:  # 힙이 비어 있지 않다면
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, num)