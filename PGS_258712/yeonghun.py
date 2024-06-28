def solution(friends, gifts):
    n = len(friends)
    idx_dict = {}
    gift_score_dict = {}
    gift_cnt = {}
    gift_arr = [[0] * n for _ in range(n)]
    for idx, friend in enumerate(friends):
        idx_dict[friend] = idx
        gift_score_dict[idx] = 0
        gift_cnt[idx] = 0

    for gift in gifts:
        give, take = gift.split()
        i, j = idx_dict.get(give), idx_dict.get(take)
        gift_arr[i][j] += 1
        gift_score_dict[i] += 1
        gift_score_dict[j] -= 1

    for i in range(n):
        for j in range(i + 1, n):
            if gift_arr[i][j] > gift_arr[j][i]:
                gift_cnt[i] += 1
            elif gift_arr[i][j] < gift_arr[j][i]:
                gift_cnt[j] += 1
            else:
                if gift_score_dict[i] > gift_score_dict[j]:
                    gift_cnt[i] += 1
                elif gift_score_dict[i] < gift_score_dict[j]:
                    gift_cnt[j] += 1

    answer = max(gift_cnt.values())

    return answer