'''
    육각형 넓이 계산.
    파인 부분은 같은 방향으로 두 번 가는 것이 포인트
    주어진 테스트케이스 처럼 3,1,3,1 연속이면 파악이 쉬운데
'''
import sys
input = sys.stdin.readline
K = int(input())
data = [list(map(int, input().split())) for _ in range(6)]
# print(data)

i, j = 0, 1
total_area = 0
exception_area = 0
while i < 6:
    # 같은 방향으로 두 번 진행한다면
    if data[i][0] == data[(i+2)%6][0] and data[j][0] == data[(j+2)%6][0]:
        exception_area = data[(i+2)%6][1] * data[j][1]  # 빼야할 넓이 == 두번 가는 방향의 중간 두번
        total_area = data[(j+3)%6][1] * data[(j+4)%6][1]  # 전체 넓이 == 두번 가는 방향 제외 나머지
        break
    i += 1
    j = (j + 1)%6

answer = (total_area - exception_area) * K
print(answer)
