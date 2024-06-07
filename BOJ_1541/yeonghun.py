import sys
input = sys.stdin.readline


data = input()
flag = 0  # '-' 있었는 지 판단
last_idx = 0  # 어디까지 잘라서 썼는지
ans = 0
for idx, s in enumerate(data):
    if s == '+' or s == '-' or idx == len(data) - 1:
        if flag == 0:
            ans += int(data[last_idx:idx])
            if s == '-':
                flag = 1
        elif flag == 1:
            ans -= int(data[last_idx:idx])
        last_idx = idx + 1
print(ans)