import sys
input = sys.stdin.readline


def tanghuru(arr, n):
    # 종류가 2개 이하면 총 길이가 답
    if len(set(arr)) <= 2:
        return n
    one_kind_steak = {'num': arr[0], 'length': 1}
    two_kinds = [arr[0]]
    total = 1
    ans = 0
    for i in range(1, n):
        if arr[i] not in two_kinds:
            if len(two_kinds) == 1:
                two_kinds.append(arr[i])
                total += 1
            else:
                ans = max(ans, total)
                two_kinds = [one_kind_steak.get('num'), arr[i]]
                total = one_kind_steak.get('length') + 1
        else:
            total += 1

        if arr[i] == one_kind_steak.get('num'):
            one_kind_steak['length'] += 1
        else:
            one_kind_steak['num'] = arr[i]
            one_kind_steak['length'] = 1

    ans = max(ans, total)
    return ans


N = int(input())
arr = list(map(int, input().split()))
print(tanghuru(arr, N))