import sys
input = sys.stdin.readline


def find_year(M, N, divided_N, x, y):
    for n in range(divided_N):
        year = x + (M * n)
        if year - y < 0:
            continue
        if (year - y) % N == 0:
            return year
    return -1


# 유클리드 호제법 최대공약수
def GCD(u, v):
    while v:
        u, v = v, u % v
    return u


T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    r = GCD(M, N)
    divided_N = N // r
    divided_M = M // r
    m = divided_N * divided_M * r  # 최소공배수

    print(find_year(M, N, divided_N, x, y))