# https://programmers.co.kr/learn/courses/30/lessons/76501

def solution(absolutes, signs):
    answer = 0
    for i, j in zip(absolutes, signs):
        if not j:
            answer -= i
        else:
            answer += i

    return answer