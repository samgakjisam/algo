def solution(cap, n, deliveries, pickups):
    deliver_lst, pickup_lst = [], []

    # 배달 거리 계산
    cnt = cap
    for i in range(n - 1, -1, -1):
        if not deliveries[i]:
            continue

        while deliveries[i] >= cnt:
            if cnt == cap:
                deliver_lst.append(i + 1)
            deliveries[i] -= cnt
            cnt = cap

        if not deliveries[i]:
            continue

        if cnt > deliveries[i]:
            if cnt == cap:
                deliver_lst.append(i + 1)
            cnt -= deliveries[i]
            deliveries[i] = 0

    # print(deliver_lst)

    # 수거 거리 계산
    cnt = cap
    for i in range(n - 1, -1, -1):
        if not pickups[i]:
            continue

        while pickups[i] >= cnt:
            if cnt == cap:
                pickup_lst.append(i + 1)
            pickups[i] -= cnt
            cnt = cap

        if not pickups[i]:
            continue

        if cnt > pickups[i]:
            if cnt == cap:
                pickup_lst.append(i + 1)
            cnt -= pickups[i]
            pickups[i] = 0

    answer = 0
    p, q = len(deliver_lst), len(pickup_lst)
    k = min(p, q)
    # 더 멀리 간 거리 합하기
    for i in range(k):
        answer += max(deliver_lst[i], pickup_lst[i])
    # 남은 거리 합하기
    if p > q:
        answer += sum(deliver_lst[q:p])
    elif p < q:
        answer += sum(pickup_lst[p:q])

    return answer * 2