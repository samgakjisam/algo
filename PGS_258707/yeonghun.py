def solution(coin, cards):
    n = len(cards)
    k = n // 3
    used = [0] * n
    turn = 1
    # 처음 뽑은 것 중 n+1 만들 수 있는 조합 수 찾기
    for i in range(k-1):
        if used[i]:
            continue
        for j in range(i+1, k):
            if used[j]:
                continue
            if cards[i] + cards[j] == n + 1:
                turn += 1
                used[i] = 1
                used[j] = 1
                break

    ni = k
    rounds = 0
    while turn:
        turn -= 1
        rounds += 1

        if ni > n - 1:
            break

        if coin:
            for i in range(k):
                if used[i]:
                    continue

                if not used[ni] and cards[i] + cards[ni] == n + 1:
                    turn += 1
                    used[i] = 1
                    used[ni] = 1
                    coin -= 1
                    if not coin:
                        break

                if not used[ni + 1] and cards[i] + cards[ni + 1] == n + 1:
                    turn += 1
                    used[i] = 1
                    used[ni + 1] = 1
                    coin -= 1
                    if not coin:
                        break

        if not turn and coin >= 2:
            flag = False
            for i in range(k, ni + 1):
                if flag:
                    break

                if used[i]:
                    continue

                for j in range(i + 1, ni + 2):
                    if used[j]:
                        continue

                    if cards[i] + cards[j] == n + 1:
                        turn += 1
                        # print(turn, i, j)
                        used[i] = 1
                        used[j] = 1
                        coin -= 2
                        # print(coin)
                        flag = True
                        break

        ni += 2

    return rounds