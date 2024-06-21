import sys
from heapq import heappush, heappop
input = sys.stdin.read


def abs_heappop(plus_heap, minus_heap):
    # 힙이 비어 있는 경우
    if not plus_heap and not minus_heap:
        return 0
    elif not plus_heap:
        return -heappop(minus_heap)
    elif not minus_heap:
        return heappop(plus_heap)

    plus_n, minus_n = heappop(plus_heap), -heappop(minus_heap)
    if -minus_n <= plus_n:
        heappush(plus_heap, plus_n)
        return minus_n
    else:
        heappush(minus_heap, -minus_n)
        return plus_n


data = list(map(int, input().strip().split('\n')))
plus_heap = []
minus_heap = []
for n in data[1:]:
    if n > 0:
        heappush(plus_heap, n)
    elif n < 0:
        heappush(minus_heap, -n)
    else:
        print(abs_heappop(plus_heap, minus_heap))