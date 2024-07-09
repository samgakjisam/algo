def solution(n, tops):
    answer = 1
    ex = 0
    
    for i in range(n):
        t = 3
        if tops[i] == 1:
            t = 4
        
        newans = answer * t - ex
        ex = answer
        answer = newans
    
    answer %= 10007
    
    return answer
