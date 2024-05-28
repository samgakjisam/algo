import sys
input = sys.stdin.readline

N = int(input())
target_set = set(map(int, input().split()))
M = int(input())
check_lst = list(map(int, input().split()))
for num in check_lst:
    if num in target_set:
        print(1)
    else:
        print(0)