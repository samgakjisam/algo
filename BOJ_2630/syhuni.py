import sys
input = sys.stdin.readline


def cut(i, j, k):
    color = paper[i][j]
    if k == 0:
        if color == 0:
            paper_count['white'] += 1
        else:
            paper_count['blue'] += 1
        return

    for di in range(i, i + 2**k):
        for dj in range(j, j + 2**k):
            if paper[di][dj] != color:
                cut(i, j, k - 1)
                cut(i + 2 ** (k - 1), j, k - 1)
                cut(i, j + 2 ** (k - 1), k - 1)
                cut(i+ 2 ** (k - 1), j + 2 ** (k - 1), k - 1)
                return
    else:
        if color == 0:
            paper_count['white'] += 1
        else:
            paper_count['blue'] += 1
        return


paper_count = {'white': 0, 'blue': 0}
N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
K = 0
while N > 1:
    N //= 2
    K += 1
cut(0, 0, K)

print(paper_count['white'])
print(paper_count['blue'])