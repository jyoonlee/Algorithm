# https://programmers.co.kr/learn/courses/30/lessons/42862

def solution(n, lost, reserve):
    print(n, lost,reserve)
    have = n - len(lost)

    for i in lost:
        for j in reserve:
            if i == j :
                have += 1
                break

            if abs(i-j) == 1 and j not in lost:
                have += 1
                reserve.remove(j)
                break


    answer = have
    return answer