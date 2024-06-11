import sys
from collections import defaultdict

input = sys.stdin.readline


def tanghuru(arr, n):
    # 종류가 2개 이하면 총 길이가 답
    if len(set(arr)) <= 2:
        return n

    left = 0
    max_len = 0
    counter = defaultdict(int)

    for right in range(n):
        counter[arr[right]] += 1

        while len(counter) > 2:
            counter[arr[left]] -= 1
            if counter[arr[left]] == 0:
                del counter[arr[left]]
            left += 1

        max_len = max(max_len, right - left + 1)

    return max_len


N = int(input())
arr = list(map(int, input().split()))
print(tanghuru(arr, N))