def solution(n, m, x, y, r, c, k):
    h_gap = r - x
    l_gap = c - y

    if abs(h_gap) + abs(l_gap) > k:
        return "impossible"

    remain_k = k - abs(h_gap) - abs(l_gap)
    if (remain_k) % 2:
        return "impossible"

    if h_gap >= 0:  # 도착점이 아래
        h = n - r  # 도착점으로부터 아래로 갈 수 있는 횟수
    else:
        h = n - x  # 출발점으로부터 아래로 갈 수 있는 횟수

    if l_gap <= 0:  # 도착점이 왼쪽
        l = c - 1  # 도착점으로부터 왼쪽으로 갈 수 있는 횟수
    else:
        l = y - 1  # 출발점으로부터 왼쪽으로 갈 수 있는 횟수

    togo_h, togo_l = 0, 0
    if remain_k:
        if h*2 >= remain_k:
            togo_h = remain_k // 2
            remain_k = 0
        else:
            togo_h = h
            remain_k -= h*2

    if remain_k:
        if l*2 >= remain_k:
            togo_l = remain_k // 2
            remain_k = 0
        else:
            togo_l = l
            remain_k -= l*2

    answer = ''
    if h_gap >= 0:
        answer += 'd' * h_gap

    if togo_h:
        answer += 'd' * togo_h

    if l_gap <= 0:
        answer += 'l' * abs(l_gap)

    if togo_l:
        answer += 'l' * togo_l

    if remain_k:
        answer += 'rl' * (remain_k // 2)

    if l_gap > 0:
        answer += 'r' * l_gap

    if togo_l:
        answer += 'r' * togo_l

    if h_gap < 0:
        answer += 'u' * abs(h_gap)

    if togo_h:
        answer += 'u' * togo_h

    return answer