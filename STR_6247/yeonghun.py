import sys
input = sys.stdin.readline

n, q = map(int, input().split())
data = sorted(list(map(int, input().split())))

idx_dict = dict()
for idx, num in enumerate(data):
    idx_dict[num] = idx

for _ in range(q):
    qi = int(input())
    q_idx = idx_dict.get(qi, 0)
    if q_idx:  # 존재하는 값이면
        print(q_idx * (n - q_idx - 1))
    else:
        print(0)