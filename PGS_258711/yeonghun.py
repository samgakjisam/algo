def solution(edges):
    from_dict = {}
    to_dict = {}
    check_lst = []
    for u, v in edges:
        if not from_dict.get(u):
            from_dict[u] = [v]
        else:
            from_dict[u].append(v)
            check_lst.append(u)

        if not to_dict.get(v):
            to_dict[v] = [u]
        else:
            to_dict[v].append(u)

    start = 0
    check_set = set(check_lst)
    for num in check_set:
        if num not in to_dict:
            start = num

    total = len(from_dict.get(start))
    eight_cnt = len(list(check_set)) - 1  # 나가는 간선 두 개 이상 정점 중 외부 정점 제외한 갯수
    bar_cnt = 0
    for edge in to_dict.keys():
        if edge not in from_dict.keys():
            bar_cnt += 1
    donut_cnt = total - eight_cnt - bar_cnt
    answer = [start, donut_cnt, bar_cnt, eight_cnt]

    return answer