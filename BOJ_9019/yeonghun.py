import sys
from collections import deque
input = sys.stdin.readline


def fill_zero(num):
    if len(num) == 4:
        return num
    else:
        while True:
            num = '0' + num
            if len(num) == 4:
                return num


def com_d(num):
    num = int(num)
    num = (num * 2) % 10000
    return fill_zero(str(num))


def com_s(num):
    num = int(num)
    num -= 1
    if num == -1:
        num = 9999
    return fill_zero(str(num))


def com_l(num):
    num = num[1:4] + num[0]
    return num


def com_r(num):
    num = num[3] + num[0:3]
    return num


def all_check(a, b, curr_com):
    na = com_d(a)
    if not visited[int(na)]:
        n_com = curr_com + 'D'
        if na == b:
            print(n_com)
            return True
        que.append([n_com, na])
        visited[int(na)] = True

    na = com_s(a)
    if not visited[int(na)]:
        n_com = curr_com + 'S'
        if na == b:
            print(n_com)
            return True
        que.append([n_com, na])
        visited[int(na)] = True

    na = com_l(a)
    if not visited[int(na)]:
        n_com = curr_com + 'L'
        if na == b:
            print(n_com)
            return True
        que.append([n_com, na])
        visited[int(na)] = True


    na = com_r(a)
    if not visited[int(na)]:
        n_com = curr_com + 'R'
        if na == b:
            print(n_com)
            return True
        que.append([n_com, na])
        visited[int(na)] = True

    return False


def find_min_command(b):
    while que:
        curr_com, curr_a = que.popleft()
        if all_check(curr_a, b, curr_com):
            return


T = int(input())
for _ in range(T):
    A, B = input().split()
    A = fill_zero(A)
    B = fill_zero(B)
    que = deque()
    visited = [False] * 10000
    glob_flag = all_check(A, B, '')
    if glob_flag:
        continue
    find_min_command(B)
