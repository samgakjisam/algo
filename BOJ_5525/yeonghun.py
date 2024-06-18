import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
S = input().strip()
PN = 'IO' * N + 'I'

cnt = 0
idx = 0
while idx <= M - (2 * N):
    if S[idx] == 'I':
        j = idx + 1
        temp_cnt = 0  # 연속된 'OI' 개수
        while j < M - 1:
            if S[j] == 'O' and S[j+1] == 'I':
                temp_cnt += 1
                j += 2
            else:
                break
        if temp_cnt >= N:
            # 연속된 'OI' 개수(temp_cnt) - N + 1 == 현재 연속된 부분에서의 P_N 개수
            cnt = cnt + temp_cnt - N + 1
        idx = j  # 연속 되지 않는 인덱스부터 검사 진행
    else:
        idx += 1

print(cnt)