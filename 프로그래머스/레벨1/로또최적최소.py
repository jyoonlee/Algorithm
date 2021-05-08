# https://programmers.co.kr/learn/courses/30/lessons/77484

def solution(lottos, win_nums):
    answer = []
    zero = 0
    opt = 0
    for i in lottos:
        if i in win_nums:
            opt += 1
        elif i == 0:
            zero += 1

    if zero == 0 and opt <= 1:
        answer.append(6)
        answer.append(6)
    else:
        a = 0
        b = 0
        if opt <= 1:
            b = 6
        else:
            b = 7 - opt

        a = 7 - (opt + zero)
        answer.append(a)
        answer.append(b)

    return answer