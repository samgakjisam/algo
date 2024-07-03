import sys
from heapq import heappush, heappop, heapify
from collections import defaultdict

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    Q = int(input())
    min_pq = []
    max_pq = []
    checker = defaultdict(int)
    q_cnt = 0
    for _ in range(Q):
        cal, num = input().split()
        num = int(num)
        if cal == 'I':
            heappush(min_pq, num)
            heappush(max_pq, -num)
            checker[num] += 1
            q_cnt += 1
        elif cal == 'D':
            if not q_cnt:  # 큐가 비었는 지 checker로 확인
                continue

            if num == -1:
                while True:
                    val = heappop(min_pq)
                    if checker[val]:
                        checker[val] -= 1
                        q_cnt -= 1
                        break
            elif num == 1:
                while True:
                    val = -heappop(max_pq)
                    if checker[val]:
                        checker[val] -= 1
                        q_cnt -= 1
                        break

    if not q_cnt:
        print('EMPTY')
    else:
        max_val = 0
        while True:
            val = -heappop(max_pq)
            if checker[val]:
                checker[val] -= 1
                q_cnt -= 1
                max_val = val
                break
        if not q_cnt:
            print(max_val, max_val)
        else:
            min_val = 0
            while True:
                val = heappop(min_pq)
                if checker[val]:
                    checker[val] -= 1
                    min_val = val
                    break
            print(max_val, min_val)
