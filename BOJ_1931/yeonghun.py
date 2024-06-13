import sys
input = sys.stdin.readline

N = int(input())
schedule = [list(map(int, input().split())) for _ in range(N)]
# 회의 종료시간 기준 오름차순 정렬 후 시작 시간 오름차순
schedule.sort(key=lambda x: (x[1], x[0]))
cnt = 1
last = 0  # 이전 회의
for i in range(1, N):
    if schedule[i][0] >= schedule[last][1]:
        cnt += 1
        last = i
print(cnt)