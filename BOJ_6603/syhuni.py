import sys
input = sys.stdin.readline


def combine(S, start, comb, k):
    if len(comb) == 6:  # 종료 조건
        print(' '.join(map(str, comb)))  # join은 str만 가능
    for i in range(start, k):
        comb.append(S[i])
        combine(S, i+1, comb, k)
        comb.pop()


while True:
    data = list(map(int, input().split()))
    k = data[0]
    S = data[1:]
    if k == 0:
        break
    combine(S, 0, [], k)
    print()