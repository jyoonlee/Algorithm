# https://programmers.co.kr/learn/courses/30/lessons/42748

def solution(array, commands):
    answer = []

    for i in commands:
        a, b, c = map(int, i)
        temp = sorted(array[a - 1:b])
        answer.append(temp[c - 1])

    return answer